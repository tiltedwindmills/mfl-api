package org.tiltedwindmills.fantasy.mfl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesResponse;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLScheduleResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;
import org.tiltedwindmills.fantasy.mfl.model.weeklyresults.WeeklyResultsResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class used in testing to mimic the {@code retrofit.converter.JacksonConverter} which the application uses to parse
 * inbound JSON data from the MFL service.  Not an ideal scenario, but having some faith that the Retrofit processor
 * doesn't do anything particularly strange.
 *
 * @author John Daniel
 */
public class JsonDataConverter {

    private static final Logger LOG = LoggerFactory.getLogger(JsonDataConverter.class);

    // our Jackson object mapper.
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // initialize this as is done in Retrofit RestAdapter setup.
    static {
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * Gets the players from the given file in the "exports/players" directory.
     *
     * @param fileName the file name, without the ".json" extension
     * @return the player response
     */
    public static final PlayerResponse players(final String fileName) {
        return getResponse(fileName, "players", PlayerResponse.class);
    }

    /**
     * Gets the scoring export from the given file in the "exports/playerScores" directory.
     *
     * @param fileName the file name
     * @return the player scores response
     */
    public static final PlayerScoresResponse playerScores(final String fileName) {
        return getResponse(fileName, "playerScores", PlayerScoresResponse.class);
    }

    /**
     * Gets the injury report from the given file in the "exports/injuries" directory.
     *
     * @param fileName the file name
     * @return the injuries response
     */
    public static final InjuriesResponse injuries(final String fileName) {
        return getResponse(fileName, "injuries", InjuriesResponse.class);
    }

    /**
     * Gets the players stat-uses/-i from the given file in the "exports/playerStatus" directory.
     *
     * @param fileName the file name
     * @return the player status response
     */
    public static final PlayerStatusResponse playerStatus(final String fileName) {
        return getResponse(fileName, "playerStatus", PlayerStatusResponse.class);
    }

    /**
     * Gets the NFL schedule from the given file in the "exports/nflSchedule" directory.
     *
     * @param fileName the file name, without the ".json" extension
     * @return the NFL schedule response
     */
    public static final NFLScheduleResponse nflSchedule(final String fileName) {
        return getResponse(fileName, "nflSchedule", NFLScheduleResponse.class);
    }

    /**
     * Gets the final results from the given file in the "exports/weeklyResults" directory.
     *
     * @param fileName the file name, without the ".json" extension
     * @return the weekly results response
     */
    public static final WeeklyResultsResponse weeklyResults(final String fileName) {
        return getResponse(fileName, "weeklyResults", WeeklyResultsResponse.class);
    }

    /** heavy lifting.  Read the appropriate file and return a response of the expected type */
    private static <T> T getResponse(final String fileName, final String directory, final Class<T> returnType) {

        try {

            final Resource resource = new ClassPathResource("exports/" + directory + "/" + fileName + ".json");
            final InputStream resourceInputStream = resource.getInputStream();

            return objectMapper.readValue(resourceInputStream, returnType);

        } catch (IOException e) {
            LOG.error("Could not load data from 'exports/{}/{}.json: {}", directory, fileName, e.getMessage(), e);
        }

        return null;
    }
}

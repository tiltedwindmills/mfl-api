package org.tiltedwindmills.fantasy.mfl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;

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
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Gets the players from the given file in the "exports/players" directory.
	 *
	 * @param fileName the file name, without the ".json" extension
	 * @return the player response
	 */
	public static final PlayerResponse players(final String fileName) {

		try {

			final Resource resource = new ClassPathResource("exports/players/" + fileName + ".json");
			final InputStream resourceInputStream = resource.getInputStream();

			return objectMapper.readValue(resourceInputStream, PlayerResponse.class);

		} catch (IOException e) {
			LOG.error("Failed to load MFL players from file: {}", e.getMessage());
		}

		return null;
	}

}

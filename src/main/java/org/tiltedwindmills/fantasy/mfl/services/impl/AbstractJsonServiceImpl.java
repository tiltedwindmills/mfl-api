package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parent class of service implementations that use JSON operations.
 */
public abstract class AbstractJsonServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractJsonServiceImpl.class);

    // common strings in messages
    private static final String SERVICE_REQUESTS = "' service requests";

    // TODO : fixme
    protected static final int CURRENT_YEAR = 2015;
    protected static final int FIRST_MFL_SUPPORTED_YEAR = 1980;

    /* TODO : make this spring bean? */

    /**
     * Gets the rest adapter.
     *
     * @param serverId the server id
     * @return the rest adapter
     */
    protected final RestAdapter getRestAdapter(final String serverId) {

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        final String server = "http://football" + ServiceUtils.safeServerId(serverId) + ".myfantasyleague.com";

        // Note:  Setting LogLevel.FULL rather than BASIC will give response body.
        return new RestAdapter.Builder()
                            .setEndpoint(server)
                            .setConverter(new JacksonConverter(objectMapper))
                            .setLog(new SLFRetrofitLogger())
                            .setLogLevel(SLFRetrofitLogger.getLogLevel())
                            .build();
    }


    /**
     * Validates a provide league ID against expected MFL parameters. ( 5 digits )
     *
     * @param leagueId the league id
     * @param serviceId the service id
     */
    protected final void validateLeagueId(final int leagueId, final String serviceId) {

        // ensure 5 digit league Id is best we can do

        // CHECKSTYLE:OFF
        // jd - eat the magic numbers
        if (leagueId < 10000 || leagueId > 99999) {
        // CHECKSTYLE:ON
            LOG.error("'{}' is an invalid league for MFL '{}' service requests", leagueId, serviceId);
            throw new MFLServiceException(leagueId + " is an invalid league for MFL '" + serviceId + SERVICE_REQUESTS);
        }
    }


    /**
     * Validates a provide week against expected MFL parameters. ( 1 - 22 )
     *
     * @param week the week
     * @param serviceId the service id
     */
    protected final void validateWeek(final int week, final String serviceId) {

        // CHECKSTYLE:OFF
        // jd - eat the magic numbers
        if (week < 1 || week > 21) {
        // CHECKSTYLE:ON
            LOG.error("'{}' is an invalid week for MFL '{}' service requests", week, serviceId);
            throw new MFLServiceException(week + " is an invalid week for MFL '" + serviceId + SERVICE_REQUESTS);
        }
    }


    /**
     * Validates a provide server ID against expected MFL parameters. ( numeric & <= 2 digits )
     *
     * @param serverId the server id
     * @param serviceId the service id
     */
    protected final void validateServerId(final String serverId, final String serviceId) {

        if (serverId == null || !serverId.matches("\\d{1,2}")) {
            LOG.error("'{}' is an invalid server for MFL '{}' service requests", serverId, serviceId);
            throw new MFLServiceException(serverId + " is an invalid server for MFL '" + serviceId + SERVICE_REQUESTS);
        }
    }

    /**
     * Validates a provide year against expected MFL parameters. ( between 1980 and current year )
     *
     * @param year the year
     * @param serviceId the service id
     */
    protected final void validateYear(final int year, final String serviceId) {

        if (year < FIRST_MFL_SUPPORTED_YEAR || year > Calendar.getInstance().get(Calendar.YEAR)) {
            LOG.error("'{}' is an invalid year for MFL '{}' service requests", year, serviceId);
            throw new MFLServiceException(year + " is an invalid year for MFL '" + serviceId + SERVICE_REQUESTS);
        }
    }
}

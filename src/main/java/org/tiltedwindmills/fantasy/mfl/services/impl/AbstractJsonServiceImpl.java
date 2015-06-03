package org.tiltedwindmills.fantasy.mfl.services.impl;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.JacksonConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parent class of service implementations that use JSON operations.
 */
public abstract class AbstractJsonServiceImpl {

	// TODO : fixme
	protected static final int CURRENT_YEAR = 2015;

	/* TODO : make this spring bean? */

	/**
	 * Gets the rest adapter.
	 *
	 * @param serverId the server id
	 * @return the rest adapter
	 */
	protected final RestAdapter getRestAdapter(final String serverId) {

		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		final String server = "http://football" + ServiceUtils.safeServerId(serverId) + ".myfantasyleague.com";

		// Note:  Setting LogLevel.FULL rather than BASIC will give response body.
		return new RestAdapter.Builder()
							  .setEndpoint(server)
							  .setConverter(new JacksonConverter(objectMapper))
							  .setLog(new SLFRetrofitLogger())
							  .setLogLevel(SLFRetrofitLogger.getLogLevel())
							  .setLogLevel(LogLevel.BASIC)
							  .build();
	}
}

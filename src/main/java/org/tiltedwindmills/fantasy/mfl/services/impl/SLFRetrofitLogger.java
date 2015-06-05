package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.RestAdapter.Log;
import retrofit.RestAdapter.LogLevel;

/**
 * An implementation of the Retrofit Log class that simply logs all output to an SLF logger at {@code info} level.
 *
 * If the class's logging level is set to {@code DEBUG}, the Retrofit logged at {@code LogLevel.FULL}.
 * If the class's logging level is set to {@code INFO}, the Retrofit logged at {@code LogLevel.BASIC}.
 * Otherwise, no output is logged.
 *
 */
public final class SLFRetrofitLogger implements Log {

	/** the logger. */
	private static final Logger LOG = LoggerFactory.getLogger(SLFRetrofitLogger.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see retrofit.RestAdapter.Log#log(java.lang.String)
	 */
	@Override
	public void log(final String message) {
		LOG.info(message);
	}

	/**
	 * Gets the log level.  Will inspect the existing system log config, and respond with a comparable log level
	 * for Retrofit.  SLF Debug will return {@code FULL}; SLF Info will return {@code BASIC}.  Everything else
	 * will return {@code NONE}.
	 *
	 * @return the log level
	 */
	public static LogLevel getLogLevel() {

		// logging options are:
		// NONE    - No logging
		// BASIC   - Log only the request method and URL and the response status code and execution time.
		// HEADERS - Log the basic information along with request and response headers.
		// FULL    - Log the headers, body, and metadata for both requests and responses.  Note: This requires that
		//			 the entire request and response body be buffered in memory!

		LogLevel level = LogLevel.NONE;

		if (LOG.isDebugEnabled()) {
			level = LogLevel.FULL;
		}
		else if (LOG.isInfoEnabled()) {
			level = LogLevel.BASIC;
		}

		return level;
	}
}


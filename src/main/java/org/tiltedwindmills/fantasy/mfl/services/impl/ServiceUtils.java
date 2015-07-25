package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Common operations for interacting with MFL APIs.
 */
public final class ServiceUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceUtils.class);

	/** DateFormat - "yyyy-MM-dd H:mm:ss" */
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd H:mm:ss");

	private ServiceUtils() {
		// utility classes should not have public or default constructor.
	}

	/**
	 * make sure we've got a legit server ID.  Otherwise return empty so the the redirect will happen.
	 *
	 * @param serverId the server id
	 * @return the string
	 */
	public static String safeServerId(final String serverId) {

		// hack-y
		String translatedServer = serverId;
		if (serverId == null || "0".equals(serverId)) {

			LOG.warn("Found invalid server id string '{}'", serverId);
			translatedServer = "";
		}

		return translatedServer;
	}

	/**
	 * make sure we've got a legit server ID.  Otherwise return empty so the the redirect will happen.
	 *
	 * @param serverId the server id
	 * @return the string
	 */
	public static String safeServerId(final int serverId) {

		// hack-y, again
		if (serverId <= 0) {

			LOG.warn("Found invalid server id {}", serverId);
			return "";
		}

		return Integer.toString(serverId);
	}

	/**
	 * Gets a string representation of right now.
	 *
	 * @return the now
	 */
	public static String getNow() {
		return getStringForCalendar(DateTime.now());
	}

	/**
	 * Gets a string representation of the given calendar.
	 *
	 * @param dateTime the date & time to parse.
	 * @return the now
	 */
	public static String getStringForCalendar(final DateTime dateTime) {
		return DATE_FORMAT.print(dateTime);
	}

	/**
	 * Gets a {@code org.joda.time.DateTime} representation of the given String.
	 *
	 * @param input the input
	 * @return the now
	 */
	public static DateTime getCalendarForString(final String input) {

		if (StringUtils.isNotBlank(input)) {
			try {

				return DATE_FORMAT.parseDateTime(input);

			} catch (IllegalArgumentException e) {

				// log it and return null.
				LOG.error("Could not parse input string '{}' into a date: {}", input, e.getMessage());
			}
		}

		return null;
	}
}

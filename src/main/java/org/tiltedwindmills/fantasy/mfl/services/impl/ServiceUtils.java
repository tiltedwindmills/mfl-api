package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Common operations for interacting with MFL APIs.
 */
public final class ServiceUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceUtils.class);

	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

	/** utility classes should not have public or default constructor */
	private ServiceUtils() { }

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

			LOG.warn("Found invalid server id string {}", serverId);
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
		if (serverId == 0) {

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
		return getStringForCalendar(Calendar.getInstance());
	}

	/**
	 * Gets a string representation of the given calendar.
	 *
	 * @param calendar the calendar
	 * @return the now
	 */
	public static String getStringForCalendar(final Calendar calendar) {
		return DATE_FORMAT.format(calendar.getTime());
	}

	/**
	 * Gets a {@code java.util.Calendar} representation of the given String.
	 *
	 * @param input the input
	 * @return the now
	 */
	public static Calendar getCalendarForString(final String input) {

		if (StringUtils.isNotBlank(input)) {
			try {

				final Calendar calendar = Calendar.getInstance();
				calendar.setTime(DATE_FORMAT.parse(input));
				return calendar;

			} catch (ParseException e) {

				// log it and return null.
				LOG.error("Could not parse input string '{}' into a date", input, e);
			}
		}

		return null;
	}
}

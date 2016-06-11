package org.tiltedwindmills.fantasy.mfl.model.injuries;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class InjuriesWrapper.
 */
public class InjuriesWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6788264238628393321L;

	/** The injuries. */
	@JsonProperty("injury")
	private List<Injury> injuries;

	/** The timestamp. */
	private String timestamp;

	/** The week. */
	private int week;

	/**
	 * Gets the injuries.
	 *
	 * @return the injuries
	 */
	public final List<Injury> getInjuries() {

		if (injuries == null) {
			injuries = new ArrayList<>();
		}

		return injuries;
	}

	/**
	 * Sets injuries.
	 *
	 * @param injuries the new injuries
	 */
	public final void setInjuries(final List<Injury> injuries) {
		this.injuries = injuries;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public final String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public final void setTimestamp(final String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the week.
	 *
	 * @return the week
	 */
	public final int getWeek() {
		return week;
	}

	/**
	 * Sets the week.
	 *
	 * @param week the new week
	 */
	public final void setWeek(final int week) {
		this.week = week;
	}
}

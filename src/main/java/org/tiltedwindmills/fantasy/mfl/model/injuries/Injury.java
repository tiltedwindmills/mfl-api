package org.tiltedwindmills.fantasy.mfl.model.injuries;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Injury.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Injury extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1696657454164924871L;

	/** The player ID. */
	@JsonProperty("id")
	private int playerId;

	/** The status. */
	private String status;

	/** The details. */
	private String details;

	/** The week. */
	@JsonIgnore
	private int week;


	/**
	 * Gets the player id.
	 *
	 * @return the player id
	 */
	public final int getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the player id.
	 *
	 * @param playerId the new player id
	 */
	public final void setPlayerId(final int playerId) {
		this.playerId = playerId;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public final void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public final String getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the new details
	 */
	public final void setDetails(final String details) {
		this.details = details;
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

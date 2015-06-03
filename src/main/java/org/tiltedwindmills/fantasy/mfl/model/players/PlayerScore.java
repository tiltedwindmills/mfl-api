package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerScore.
 */
public class PlayerScore extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -148365220120879752L;

	/** The player id. */
	@JsonProperty("id")
	private int playerId;

	/** The week. */
	private String week;

	/** The score. */
	private String score;

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
	 * Gets the week.
	 *
	 * @return the week
	 */
	public final String getWeek() {
		return week;
	}

	/**
	 * Sets the week.
	 *
	 * @param week the new week
	 */
	public final void setWeek(final String week) {
		this.week = week;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public final String getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public final void setScore(final String score) {
		this.score = score;
	}
}

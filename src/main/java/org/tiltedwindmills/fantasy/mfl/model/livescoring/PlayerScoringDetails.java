package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@code <player id="9448" score="21.80" gameSecondsRemaining="0" status="starter" updatedStats=""/>}
 */
public class PlayerScoringDetails extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4144181355578954388L;

	/** The player id. */
	@JsonProperty("id")
	private int playerId;

	/** The score. */
	private double score;

	/** The game seconds remaining. */
	private int gameSecondsRemaining;

	/** The status. */
	private String status;

	/** The updated stats. */
	private String updatedStats;


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
	 * Gets the score.
	 *
	 * @return the score
	 */
	public final double getScore() {

		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public final void setScore(final double score) {

		this.score = score;
	}

	/**
	 * Gets the game seconds remaining.
	 *
	 * @return the game seconds remaining
	 */
	public final int getGameSecondsRemaining() {

		return gameSecondsRemaining;
	}

	/**
	 * Sets the game seconds remaining.
	 *
	 * @param gameSecondsRemaining the new game seconds remaining
	 */
	public final void setGameSecondsRemaining(final int gameSecondsRemaining) {

		this.gameSecondsRemaining = gameSecondsRemaining;
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
	 * Gets the updated stats.
	 *
	 * @return the updated stats
	 */
	public final String getUpdatedStats() {

		return updatedStats;
	}

	/**
	 * Sets the updated stats.
	 *
	 * @param updatedStats the new updated stats
	 */
	public final void setUpdatedStats(final String updatedStats) {

		this.updatedStats = updatedStats;
	}
}

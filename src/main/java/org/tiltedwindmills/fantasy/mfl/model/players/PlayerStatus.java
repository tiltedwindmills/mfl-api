package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerScore.
 */
public class PlayerStatus extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3751405581376916615L;

	/** The player id. */
	@JsonProperty("id")
	private int playerId;

	/** The status. */
	private String status;

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
}

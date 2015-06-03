package org.tiltedwindmills.fantasy.mfl.model.rosters;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;
import org.tiltedwindmills.fantasy.mfl.model.PlayerStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class RosterPlayer.
 */
public class RosterPlayer extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7876223182278631154L;

	/** The player id. */
	@JsonProperty("id")
	private int playerId;

	/** The status. */
	private PlayerStatus status;

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
	public final PlayerStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public final void setStatus(final PlayerStatus status) {
		this.status = status;
	}
}

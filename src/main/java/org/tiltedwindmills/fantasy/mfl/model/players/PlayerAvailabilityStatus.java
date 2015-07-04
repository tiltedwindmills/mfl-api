package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerAvailabilityStatus.  Defines the current state of a player respective to his ownership in a
 * specific MFL league.  ( e.g. locked, free agent, rostered, etc. ).  Will typically be either "Free Agent" or the
 * name of the team owning the player.  Depending on current lineup submission, this could also be appended with the
 * lineup status. ( e.g. "Team A", or "Team A - NS", etc. )
 *
 * @author John Daniel
 */
public class PlayerAvailabilityStatus extends AbstractObject {

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

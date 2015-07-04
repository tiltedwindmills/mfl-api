package org.tiltedwindmills.fantasy.mfl.model.players;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerStatusWrapper.
 */
public class PlayerStatusWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2285602019818286163L;

	/** The player statuses. */
	@JsonProperty("playerStatus")
	private List<PlayerAvailabilityStatus> playerStatuses;

	/**
	 * Gets the player statuses.
	 *
	 * @return the player statuses
	 */
	public final List<PlayerAvailabilityStatus> getPlayerStatuses() {
		return playerStatuses;
	}

	/**
	 * Sets the player statuses.
	 *
	 * @param playerStatuses the new player statuses
	 */
	public final void setPlayerStatuses(final List<PlayerAvailabilityStatus> playerStatuses) {
		this.playerStatuses = playerStatuses;
	}
}

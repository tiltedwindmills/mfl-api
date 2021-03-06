package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerStatusResponse.  Note the differences between the response objects when a single player is
 * requested vs. multiple.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatusResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1311614876244706842L;

	/** The wrapper. This element is present when multiple player statuses are returned.*/
	@JsonProperty("playerStatuses")
	private PlayerStatusWrapper wrapper;

	/** The player status. This is the fundamental element returned when a single player status is returned. */
	@JsonProperty("playerStatus")
	private PlayerAvailabilityStatus playerAvailabilityStatus;

	/** The error. */
	@JsonProperty("error")
	private PlayerErrorMessage error;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final PlayerStatusWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final PlayerStatusWrapper wrapper) {
		this.wrapper = wrapper;
	}

	/**
	 * Gets the player status.
	 *
	 * @return the player status
	 */
	public final PlayerAvailabilityStatus getPlayerAvailabilityStatus() {
		return playerAvailabilityStatus;
	}

	/**
	 * Sets the player status.
	 *
	 * @param playerAvailabilityStatus the new player status
	 */
	public final void setPlayerAvailabilityStatus(final PlayerAvailabilityStatus playerAvailabilityStatus) {
		this.playerAvailabilityStatus = playerAvailabilityStatus;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public final PlayerErrorMessage getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public final void setError(final PlayerErrorMessage error) {
		this.error = error;
	}
}

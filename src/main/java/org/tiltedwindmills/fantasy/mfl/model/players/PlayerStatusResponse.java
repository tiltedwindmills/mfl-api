package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerStatusResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatusResponse extends AbstractObject {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1311614876244706842L;

    /** The wrapper. */
    @JsonProperty("playerStatuses")
    private PlayerStatusWrapper wrapper;

    /** The player status. */
    private PlayerStatus playerStatus;

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
    public final PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    /**
     * Sets the player status.
     *
     * @param playerStatus the new player status
     */
    public final void setPlayerStatus(final PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
}

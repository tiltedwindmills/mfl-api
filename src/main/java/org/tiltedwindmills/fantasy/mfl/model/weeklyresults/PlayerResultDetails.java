package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;
import org.tiltedwindmills.fantasy.mfl.services.util.BooleanDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <pre>
 * {
 *    status: "starter",
 *    score: "18.50",
 *    shouldStart: "1",
 *    id: "4925"
 * }
 * </pre>
 */
public class PlayerResultDetails extends AbstractObject {

    private static final long serialVersionUID = 8113780038307581767L;

    /** The player id. */
    @JsonProperty("id")
    private int playerId;

    /** The score. */
    private double score;

    /** The status. */
    private String status;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean shouldStart;


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
     * Gets the should start.
     *
     * @return the should start
     */
    public final boolean getShouldStart() {
        return shouldStart;
    }

    /**
     * Sets the should start.
     *
     * @param shouldStart the new should start
     */
    public final void setShouldStart(final boolean shouldStart) {
        this.shouldStart = shouldStart;
    }
}

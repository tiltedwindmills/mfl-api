package org.tiltedwindmills.fantasy.mfl.model.draft;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates a MFL "draft" export selection.
 *
 * @author John Daniel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftPick extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1696657454164924871L;

	/** The player ID. */
	@JsonProperty("player")
	private int playerId;

	/** The round. */
	private String round;

	/** The pick. */
	private String pick;

	/** The franchise. */
	private String franchise;

	/** The timestamp. */
	private String timestamp;

	/** The comments. */
	private String comments;

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
	 * Gets the round.
	 *
	 * @return the round
	 */
	public final String getRound() {
		return round;
	}

	/**
	 * Sets the round.
	 *
	 * @param round the new round
	 */
	public final void setRound(final String round) {
		this.round = round;
	}

	/**
	 * Gets the pick.
	 *
	 * @return the pick
	 */
	public final String getPick() {
		return pick;
	}

	/**
	 * Sets the pick.
	 *
	 * @param pick the new pick
	 */
	public final void setPick(final String pick) {
		this.pick = pick;
	}

	/**
	 * Gets the franchise.
	 *
	 * @return the franchise
	 */
	public final String getFranchise() {
		return franchise;
	}

	/**
	 * Sets the franchise.
	 *
	 * @param franchise the new franchise
	 */
	public final void setFranchise(final String franchise) {
		this.franchise = franchise;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public final String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public final void setTimestamp(final String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public final String getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public final void setComments(final String comments) {
		this.comments = comments;
	}
}

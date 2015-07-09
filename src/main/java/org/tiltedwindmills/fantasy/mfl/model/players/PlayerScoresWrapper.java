package org.tiltedwindmills.fantasy.mfl.model.players;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerScoresWrapper.
 */
public class PlayerScoresWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3888292356519878982L;

	/** The player scores. */
	@JsonProperty("playerScore")
	private List<PlayerScore> playerScores;

	/**
	 * Gets the player scores.
	 *
	 * @return the player scores
	 */
	public final List<PlayerScore> getPlayerScores() {
		// TODO : need null safety
		return playerScores;
	}

	/**
	 * Sets the player scores.
	 *
	 * @param playerScores the new player scores
	 */
	public final void setPlayerScores(final List<PlayerScore> playerScores) {
		this.playerScores = playerScores;
	}
}

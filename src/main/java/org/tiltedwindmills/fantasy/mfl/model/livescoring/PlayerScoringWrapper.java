package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerScoringWrapper.
 */
public class PlayerScoringWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -915025478645628654L;

	/** The player scores. */
	@JsonProperty("player")
	private List<PlayerScoringDetails> playerScores;

	/**
	 * Gets the player scores.
	 *
	 * @return the player scores
	 */
	public final List<PlayerScoringDetails> getPlayerScores() {

		if (playerScores == null) {
			playerScores = new ArrayList<PlayerScoringDetails>();
		}
		return playerScores;
	}

	/**
	 * Sets the player scores.
	 *
	 * @param playerScores the new player scores
	 */
	public final void setPlayerScores(final List<PlayerScoringDetails> playerScores) {

		this.playerScores = playerScores;
	}
}

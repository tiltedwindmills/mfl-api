package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <franchise id="0001" score="21.80" gameSecondsRemaining="0"
 * 			  playersYetToPlay="0" playersCurrentlyPlaying="0" isHome="0">
 */
public class TeamScoringDetails extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 504360430488273723L;

	/** The franchise id. */
	@JsonProperty("id")
	private String franchiseId;

	/** The score. */
	private double score;

	/** The game seconds remaining. */
	private int gameSecondsRemaining;

	/** The players remaining. */
	@JsonProperty("playersYetToPlay")
	private int playersRemaining;

	/** The players playing. */
	@JsonProperty("playersCurrentlyPlaying")
	private int playersPlaying;

	/** The home. */
	@JsonProperty("isHome")
	private String home;

	/** The player scores. */
	@JsonProperty("players")
	private PlayerScoringWrapper playerScoresWrapper;

	/**
	 * Gets the franchise id.
	 *
	 * @return the franchise id
	 */
	public final String getFranchiseId() {
		return franchiseId;
	}

	/**
	 * Sets the franchise id.
	 *
	 * @param franchiseId the new franchise id
	 */
	public final void setFranchiseId(final String franchiseId) {
		this.franchiseId = franchiseId;
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
	 * Gets the game seconds remaining.
	 *
	 * @return the game seconds remaining
	 */
	public final int getGameSecondsRemaining() {
		return gameSecondsRemaining;
	}

	/**
	 * Sets the game seconds remaining.
	 *
	 * @param gameSecondsRemaining the new game seconds remaining
	 */
	public final void setGameSecondsRemaining(final int gameSecondsRemaining) {
		this.gameSecondsRemaining = gameSecondsRemaining;
	}

	/**
	 * Gets the players remaining.
	 *
	 * @return the players remaining
	 */
	public final int getPlayersRemaining() {
		return playersRemaining;
	}

	/**
	 * Sets the players remaining.
	 *
	 * @param playersRemaining the new players remaining
	 */
	public final void setPlayersRemaining(final int playersRemaining) {
		this.playersRemaining = playersRemaining;
	}

	/**
	 * Gets the players playing.
	 *
	 * @return the players playing
	 */
	public final int getPlayersPlaying() {
		return playersPlaying;
	}

	/**
	 * Sets the players playing.
	 *
	 * @param playersPlaying the new players playing
	 */
	public final void setPlayersPlaying(final int playersPlaying) {
		this.playersPlaying = playersPlaying;
	}

	/**
	 * Checks if is home.
	 *
	 * @return the string
	 */
	public final String isHome() {
		return home;
	}

	/**
	 * Sets the home.
	 *
	 * @param home the new home
	 */
	public final void setHome(final String home) {
		this.home = home;
	}

	/**
	 * Gets the player scores.
	 *
	 * @return the player scores
	 */
	public final PlayerScoringWrapper getPlayerScoresWrapper() {
		return playerScoresWrapper;
	}

	/**
	 * Sets the player scores.
	 *
	 * @param playerScoresWrapper the new player scores
	 */
	public final void setPlayerScoresWrapper(final PlayerScoringWrapper playerScoresWrapper) {
		this.playerScoresWrapper = playerScoresWrapper;
	}
}

package org.tiltedwindmills.fantasy.mfl.model.nflschedule;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NFLMatchup.
 */
public class NFLMatchup extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2766560372173160143L;

	/** The teams. */
	@JsonProperty("team")
	private List<NFLTeam> teams;

	/** The kickoff time. */
	private long kickoff;

	/** The game seconds remaining. */
	private int gameSecondsRemaining;

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public final List<NFLTeam> getTeams() {

		if (teams == null) {
			teams = new ArrayList<NFLTeam>();
		}
		return teams;
	}

	/**
	 * Sets the teams.
	 *
	 * @param teams the new teams
	 */
	public final void setTeams(final List<NFLTeam> teams) {
		this.teams = teams;
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
	 * Gets the kickoff time.
	 *
	 * @return the kickoff
	 */
	public final long getKickoff() {
		return kickoff;
	}

	/**
	 * Sets the kickoff time.
	 *
	 * @param kickoff the new kickoff
	 */
	public final void setKickoff(final long kickoff) {
		this.kickoff = kickoff;
	}
}

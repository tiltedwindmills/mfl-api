package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LiveScoringWrapper.
 */
public class LiveScoringWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1910959321490055559L;

	/** The week. */
	private int week;

	/** The matchups. */
	@JsonProperty("matchup")
	private List<Matchup> matchups;

	/** The franchises that aren't in matchups this week. */
	@JsonProperty("franchise")
	private List<TeamScoringDetails> teamsWithoutMatchup;


	/**
	 * Gets the matchups.
	 *
	 * @return the matchups
	 */
	public final List<Matchup> getMatchups() {

		if (matchups == null) {
			matchups = new ArrayList<Matchup>();
		}
		return matchups;
	}

	/**
	 * Sets the matchups.
	 *
	 * @param matchups the new matchups
	 */
	public final void setMatchups(final List<Matchup> matchups) {

		this.matchups = matchups;
	}

	/**
	 * Gets the week.
	 *
	 * @return the week
	 */
	public final int getWeek() {

		return week;
	}

	/**
	 * Sets the week.
	 *
	 * @param week the new week
	 */
	public final void setWeek(final int week) {

		this.week = week;
	}

	/**
	 * Gets the teams without matchup.
	 *
	 * @return the teams without matchup
	 */
	public final List<TeamScoringDetails> getTeamsWithoutMatchup() {

		if (teamsWithoutMatchup == null) {
			teamsWithoutMatchup = new ArrayList<TeamScoringDetails>();
		}
		return teamsWithoutMatchup;
	}

	/**
	 * Sets the teams without matchup.
	 *
	 * @param teamsWithoutMatchup the new teams without matchup
	 */
	public final void setTeamsWithoutMatchup(final List<TeamScoringDetails> teamsWithoutMatchup) {

		this.teamsWithoutMatchup = teamsWithoutMatchup;
	}
}

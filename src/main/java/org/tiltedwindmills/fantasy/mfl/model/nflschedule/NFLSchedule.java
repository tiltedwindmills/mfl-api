package org.tiltedwindmills.fantasy.mfl.model.nflschedule;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NFLSchedule.
 */
public class NFLSchedule extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6370606404464694029L;

	/** The week. */
	private int week;

	/** The matchups. */
	@JsonProperty("matchup")
	private List<NFLMatchup> matchups;

	/**
	 * Gets the matchups.
	 *
	 * @return the matchups
	 */
	public final List<NFLMatchup> getMatchups() {

		if (matchups == null) {
			matchups = new ArrayList<NFLMatchup>();
		}
		return matchups;
	}

	/**
	 * Sets the matchups.
	 *
	 * @param matchups the new matchups
	 */
	public final void setMatchups(final List<NFLMatchup> matchups) {
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
}

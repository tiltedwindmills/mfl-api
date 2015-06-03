package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Matchup.
 */
public class Matchup extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2892798771837016141L;

	/** The teams. */
	@JsonProperty("franchise")
	private List<TeamScoringDetails> teams;

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public final List<TeamScoringDetails> getTeams() {

		if (teams == null) {
			teams = new ArrayList<TeamScoringDetails>();
		}
		return teams;
	}

	/**
	 * Sets the teams.
	 *
	 * @param teams the new teams
	 */
	public final void setTeams(final List<TeamScoringDetails> teams) {

		this.teams = teams;
	}
}

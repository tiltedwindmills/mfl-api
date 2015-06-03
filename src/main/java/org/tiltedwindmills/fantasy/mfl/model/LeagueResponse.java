package org.tiltedwindmills.fantasy.mfl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Encapsulates the response from a request to the "league" MFL export.
 */
@JsonIgnoreProperties({ "encoding", "version" })
public class LeagueResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5065448788263130726L;

	/** The league. */
	private League league;

	/**
	 * Gets the league.
	 *
	 * @return the league
	 */
	public final League getLeague() {
		return league;
	}

	/**
	 * Sets the league.
	 *
	 * @param league the new league
	 */
	public final void setLeague(final League league) {
		this.league = league;
	}
}

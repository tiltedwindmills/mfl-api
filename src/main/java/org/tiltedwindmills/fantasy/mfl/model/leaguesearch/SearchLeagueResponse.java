package org.tiltedwindmills.fantasy.mfl.model.leaguesearch;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Encapsulates the response from a request to the "league" MFL export.
 */
@JsonIgnoreProperties({ "encoding", "version" })
public class SearchLeagueResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5307381541036117808L;

	/** The leagues. */
	private LeagueSearchResultWrapper leagues;

	/**
	 * Gets the leagues.
	 *
	 * @return the leagues
	 */
	public final LeagueSearchResultWrapper getLeagues() {

		return leagues;
	}

	/**
	 * Sets the leagues.
	 *
	 * @param leagues the leagues to set
	 */
	public final void setLeagues(final LeagueSearchResultWrapper leagues) {

		this.leagues = leagues;
	}
}

package org.tiltedwindmills.fantasy.mfl.model.leaguesearch;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LeagueSearchResultWrapper.
 */
public class LeagueSearchResultWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5934492171272179629L;

	/** The leagues. */
	@JsonProperty("league")
	private List<LeagueSearchResult> leagues;


	/**
	 * Gets the leagues.
	 *
	 * @return the leagues
	 */
	public final List<LeagueSearchResult> getLeagues() {

		if (leagues == null) {
			leagues = new ArrayList<LeagueSearchResult>();
		}

		return leagues;
	}

	/**
	 * Sets the leagues.
	 *
	 * @param leagues the new leagues
	 */
	public final void setLeagues(final List<LeagueSearchResult> leagues) {

		this.leagues = leagues;
	}
}

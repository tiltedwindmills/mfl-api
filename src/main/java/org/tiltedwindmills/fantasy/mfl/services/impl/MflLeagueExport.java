package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.tiltedwindmills.fantasy.mfl.model.LeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftResultsResponse;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.SearchLeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringResponse;
import org.tiltedwindmills.fantasy.mfl.model.standings.StandingsResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Retrofit interface for MFL League API calls.
 */
public interface MflLeagueExport {

	/**
	 * Gets the league.
	 *
	 * @param league the league
	 * @param year the year
	 * @return the league
	 */
	@GET("/{year}/export?TYPE=league&JSON=1")
	LeagueResponse getLeague(@Query("L") int league, @Path("year") int year);


	/**
	 * Gets the league.
	 *
	 * http://football.myfantasyleague.com/2013/export?TYPE=league&JSON=0&L=10779&FRANCHISE=0001&PASSWORD=foobar
	 *
	 * @param league the league
	 * @param franchiseId the franchise id
	 * @param password the password
	 * @param year the year
	 * @return the league
	 */
	@GET("/{year}/export?TYPE=league&JSON=1")
	LeagueResponse getLeague(@Query("L") int league,
							 @Query("FRANCHISE") String franchiseId,
							 @Query("PASSWORD") String password,
							 @Path("year") int year);

	/**
	 * Search leagues by email.
	 *
	 * @param email the email
	 * @param year the year
	 * @return the search league response
	 */
	@GET("/{year}/export?TYPE=leagueSearch&JSON=1")
	SearchLeagueResponse searchLeaguesByEmail(@Query("SEARCH") String email, @Path("year") int year);


	/**
	 * Search leagues by id.
	 *
	 * @param id the id
	 * @param year the year
	 * @return the search league response
	 */
	@GET("/{year}/export?TYPE=leagueSearch&JSON=1")
	SearchLeagueResponse searchLeaguesById(@Query("SEARCH") String id, @Path("year") int year);

	/**
	 * Gets the live scoring.
	 *
	 * http://football3.myfantasyleague.com/2013/export?TYPE=liveScoring&L=10779&W=3&JSON=0
	 *
	 * @param league the league
	 * @param week the week
	 * @param year the year
	 * @return the live scoring
	 */
	@GET("/{year}/export?TYPE=liveScoring&JSON=1")
	LiveScoringResponse getLiveScoring(@Query("L") int league, @Query("W") int week, @Path("year") int year);

	/**
	 * Gets the standings.
	 *
	 * @param league the league
	 * @param year the year
	 * @return the standings
	 */
	@GET("/{year}/export?TYPE=standings&JSON=1")
	StandingsResponse getStandings(@Query("L") int league, @Path("year") int year);

	@GET("/{year}/export?TYPE=draftResults&JSON=1")
	DraftResultsResponse getDraftResults(@Query("L") int league, @Path("year") int year);

}

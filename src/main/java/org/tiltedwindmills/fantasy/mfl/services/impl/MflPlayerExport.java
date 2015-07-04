package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Retrofit interface for MFL League API calls.
 */
public interface MflPlayerExport {

	/**
	 * Gets the players.  This will always return the detailed view of the players.
	 *
	 * @param playerIds the player ids
	 * @param year the year
	 * @return the players
	 */
	@GET("/{year}/export?TYPE=players&JSON=1&DETAILS=1")
	PlayerResponse getPlayers(@Query("PLAYERS") String playerIds, @Path("year") int year);

	/**
	 * Gets the all players.  This will always return the detailed view of the players.
	 *
	 * @param year the year
	 * @return the all players
	 */
	@GET("/{year}/export?TYPE=players&JSON=1&DETAILS=1")
	PlayerResponse getAllPlayers(@Path("year") int year);

	/**
	 * Gets the all players since.
	 *
	 * @param since the since
	 * @param year the year
	 * @return the all players since
	 */
	@GET("/{year}/export?TYPE=players&JSON=1&DETAILS=1")
	PlayerResponse getAllPlayersSince(@Query("SINCE") String since, @Path("year") int year);

	/**
	 * Gets the injuries.
	 *
	 * @param week the week
	 * @param year the year
	 * @return the injuries
	 */
	@GET("/{year}/export?TYPE=injuries&JSON=1")
	InjuriesResponse getInjuries(@Query("W") int week, @Path("year") int year);

	/**
	 * Gets a players scores.
	 *
	 * @param league the league
	 * @param playerId the player id
	 * @param week the week
	 * @param year the year
	 * @return the all players since
	 */
	@GET("/{year}/export?TYPE=playerScores&JSON=1")
	PlayerScoresResponse getPlayerScores(@Query("L") int league,
										@Query("PLAYERS") String playerId,
										@Query("W") String week,
										@Path("year") int year);
//	http://football7.myfantasyleague.com/2012/export?TYPE=playerScores&L=35465&PLAYERS=8658,3291&W=YTD

	/**
	 * Gets the player's league availability status. ( e.g. locked, free agent, rostered, etc. )
	 *
	 * @param league the league
	 * @param playerIds the player ids ( comma separated list )
	 * @param year the year
	 * @return the player status
	 */
	@GET("/{year}/export?TYPE=playerStatus&JSON=1")
	PlayerStatusResponse getPlayerStatus(@Query("L") int league,
										@Query("P") String playerIds,
										@Path("year") int year);
//	http://football3.myfantasyleague.com/2013/export?TYPE=playerStatus&L=10779&P=8658,10788,9999999999
}

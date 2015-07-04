package org.tiltedwindmills.fantasy.mfl.services;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.injuries.Injury;

/**
 * Interface defining operations required for working with MFL Player entities.
 */
public interface PlayerService {

	/**
	 * Gets the players.
	 *
	 * @param playerIds the player ids
	 * @return the players
	 */
	List<Player> getPlayers(List<String> playerIds);

	/**
	 * Gets the players since date.
	 *
	 * @param calendar the calendar
	 * @return the players since date
	 */
	List<Player> getPlayersSinceDate(Calendar calendar);

	/**
	 * Gets the all players.
	 *
	 * @return the all players
	 */
	List<Player> getAllPlayers();

	/**
	 * Gets the player scores.
	 *
	 * @param leagueId the league id
	 * @param playerId the player id
	 * @param serverId the server id
	 * @param currentYear the current year
	 * @return the player scores
	 */
	Map<Integer, Double> getWeeklyScores(int leagueId, int playerId, String serverId, int currentYear);


	/**
	 * Gets multiple players scores.
	 *
	 * @param leagueId the league id
	 * @param playerIds the player ids
	 * @param week the week
	 * @param serverId the server id
	 * @param currentYear the current year
	 * @return the multiple players scores
	 */
	Map<Integer, Double> getMultiplePlayersScores(int leagueId,
												List<Integer> playerIds,
												String week,
												String serverId,
												int currentYear);

	/**
	 * Gets the all injuries.
	 *
	 * @param week the week
	 * @param year the year
	 * @return the all injuries
	 */
	List<Injury> getAllInjuries(int week, int year);

	/**
	 * Gets the player's availability status in their MFL league. ( e.g. locked, free agent, rostered, etc. ).  Note
	 * that invalid player IDs will not throw an error, but are rather responded as <i>"League Does Not Use This
	 * Position"</i>.
	 *
	 * @param leagueId the league id
	 * @param playerIds the player ids
	 * @param serverId the server id
	 * @param year the MFL league year of the site being requested
	 * @return the mapping of player ID to league availability status.
	 */
	Map<Integer, String> getPlayerAvailability(int leagueId, Set<String> playerIds, String serverId, int year);
}

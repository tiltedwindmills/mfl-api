package org.tiltedwindmills.fantasy.mfl.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
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
     * Gets the player updates since a given date.
     *
     * @param date the date after which the MFL player updates will be reported
     * @return the players updated in MF since the provided date
     */
    List<Player> getPlayersSinceDate(DateTime date);

    /**
     * Gets the all players.
     *
     * @return the all players
     */
    List<Player> getAllPlayers();

    /**
     * Gets the weekly scores for a specific player.  This will return all available scores for the provided year.  Bye
     * weeks, future weeks, and any other weeks without a score ( e.g. injuries or suspensions ) will not be in the
     * returned map.  Weeks played without recording a scorable stat will be returned.
     *
     * @param leagueId the league id
     * @param playerId the player id
     * @param serverId the server id
     * @param year the MFL league year of the site being requested
     * @return the player scores
     */
    Map<Integer, Double> getWeeklyScores(int leagueId, int playerId, String serverId, int year);


    /**
     * Retrieves a mapping of player IDs to their average scores.
     *
     * @param leagueId the league id
     * @param playerIds the IDs for the scoring players.
     * @param serverId the server id
     * @param year the MFL league year of the site being requested
     * @return the mapping of player IDs to their average scores
     */
    Map<Integer, Double> getAveragePlayerScores(int leagueId, Set<Integer> playerIds, String serverId, int year);

    /**
     * Retrieves a mapping of player IDs to their year to date scores.
     *
     * @param leagueId the league id
     * @param playerIds the IDs for the scoring players.
     * @param serverId the server id
     * @param year the MFL league year of the site being requested
     * @return the mapping of player IDs to their year to date scores
     */
    Map<Integer, Double> getYearToDatePlayerScores(int leagueId, Set<Integer> playerIds, String serverId, int year);

    /**
     * Gets the all injuries.
     *
     * @param week the week
     * @param year the MFL league year of the site being requested
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
    Map<Integer, String> getPlayerAvailability(int leagueId, Set<Integer> playerIds, String serverId, int year);
}

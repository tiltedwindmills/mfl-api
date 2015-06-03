package org.tiltedwindmills.fantasy.mfl.services;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.League;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftPick;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResult;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringWrapper;
import org.tiltedwindmills.fantasy.mfl.model.standings.Standings;

/**
 * Interface defining operations required for working with MFL League entities.
 */
public interface LeagueService {

	/**
	 * Search the leagues.
	 *
	 * @param email the email
	 * @param year the year
	 * @return a list of leagues.
	 */
	List<LeagueSearchResult> searchLeagues(String email, int year);

	/**
	 * Gets the league.
	 *
	 * @param mflLeagueId the mfl league id
	 * @param serverId the server id
	 * @return the league
	 */
	League getLeague(int mflLeagueId, String serverId);

	/**
	 * Gets the league.
	 *
	 * @param mflLeagueId the mfl league id
	 * @param franchiseId the franchise id
	 * @param password the password
	 * @param serverId the server id
	 * @return the league
	 */
	League getLeague(int mflLeagueId, java.lang.String franchiseId, String password, String serverId);

	/**
	 * Gets the live scoring.
	 *
	 * @param mflLeagueId the mfl league id
	 * @param week the week
	 * @param serverId the server id
	 * @return the live scoring
	 */
	LiveScoringWrapper getLiveScoring(int mflLeagueId, int week, String serverId);

	/**
	 * Gets the standings.
	 *
	 * @param mflLeagueId the mfl league id
	 * @param serverId the server id
	 * @param year the year
	 * @return the standings
	 */
	List<Standings> getStandings(int mflLeagueId, String serverId, int year);


	List<DraftPick> getDraftPicks(int mflLeagueId, String serverId, int year);
}

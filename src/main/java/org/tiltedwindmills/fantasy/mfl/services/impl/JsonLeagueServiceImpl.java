package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.tiltedwindmills.fantasy.mfl.model.League;
import org.tiltedwindmills.fantasy.mfl.model.LeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.Position;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftPick;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftResultsResponse;
import org.tiltedwindmills.fantasy.mfl.model.freeagents.FreeAgentsResponse;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResult;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResultWrapper;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.SearchLeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringResponse;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringWrapper;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.Matchup;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.TeamScoringDetails;
import org.tiltedwindmills.fantasy.mfl.model.standings.Standings;
import org.tiltedwindmills.fantasy.mfl.model.standings.StandingsResponse;
import org.tiltedwindmills.fantasy.mfl.model.weeklyresults.WeeklyResultsResponse;
import org.tiltedwindmills.fantasy.mfl.model.weeklyresults.WeeklyResultsWrapper;
import org.tiltedwindmills.fantasy.mfl.services.LeagueService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;

/**
 * JSON implementation of the {@link LeagueService}
 */
@Service
public final class JsonLeagueServiceImpl extends AbstractJsonServiceImpl implements LeagueService {

	private static final Logger LOG = LoggerFactory.getLogger(JsonLeagueServiceImpl.class);

	// service names for validation routines
	private static final String WEEKLY_RESULTS_SERVICE = "weekly results";

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.LeagueService#searchLeagues(java.lang.String, int)
	 */
	@Override
	public List<LeagueSearchResult> searchLeagues(final String email, final int year) {

		LOG.info("Searching {} leagues with email: {}", year, email);

		// no server ID needed for searching.
		final String serverId = "";

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final SearchLeagueResponse searchLeagueResponse = leagueExport.searchLeaguesByEmail(email, year);

		final LeagueSearchResultWrapper leagueWrapper = searchLeagueResponse.getLeagues();
		return leagueWrapper.getLeagues();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.LeagueService#getLeague(int, java.lang.String)
	 */
	@Override
	public League getLeague(final int mflLeagueId, final String serverId) {

		LOG.info("Retrieving {} league with ID: {}", CURRENT_YEAR, mflLeagueId);
		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final LeagueResponse leagueResponse = leagueExport.getLeague(mflLeagueId, CURRENT_YEAR);

		return leagueResponse.getLeague();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.LeagueService#getLeague(int, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public League getLeague(final int mflLeagueId, final String franchiseId, final String password,
			final String serverId) {

		LOG.info("Retrieving full details for {} league with ID: {}", CURRENT_YEAR, mflLeagueId);
		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final LeagueResponse leagueResponse = leagueExport.getLeague(mflLeagueId, franchiseId, password, CURRENT_YEAR);

		return leagueResponse.getLeague();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.LeagueService#getLiveScoring(int, int, java.lang.String)
	 */
	@Override
	public LiveScoringWrapper getLiveScoring(final int mflLeagueId, final int week, final String serverId) {

		LOG.info("Loading league {} scoring for {} week {}", mflLeagueId, CURRENT_YEAR, week);

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final LiveScoringResponse liveScoringResponse = leagueExport.getLiveScoring(mflLeagueId, week, CURRENT_YEAR);

		// iterate the response object to get rid of the weird issue where MFL returns two teams on bye in a matchup
		for (final Iterator<Matchup> i = liveScoringResponse.getLiveScoring().getMatchups().iterator(); i.hasNext();) {

			final Matchup matchup = i.next();

			// TODO : document this behavior

			boolean foundLegitFranchise = false;
			for (TeamScoringDetails tsd : matchup.getTeams()) {

				// if "BYE" is the franchise ID, its no good.
				if (!"BYE".equals(tsd.getFranchiseId())) {
					foundLegitFranchise = true;
					break;
				}
			}

			// if we failed to find a real team in the list, kill it.
			if (!foundLegitFranchise) {
				i.remove();
			}
		}

		return liveScoringResponse.getLiveScoring();
	}

	@Override
	public WeeklyResultsWrapper getWeeklyResults(
			final int mflLeagueId, final int week, final String serverId, final int year) {

		validateLeagueId(mflLeagueId, WEEKLY_RESULTS_SERVICE);
		validateServerId(serverId, WEEKLY_RESULTS_SERVICE);
		validateYear(year, WEEKLY_RESULTS_SERVICE);

		try {
			final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
			final WeeklyResultsResponse response = leagueExport.getWeeklyResults(mflLeagueId, week, year);

			if (response == null) {
				LOG.error("Invalid response retrieving weekly results for week {} in league {}.", week, mflLeagueId);
				throw new MFLServiceException("Invalid response retrieving weekly results");
			}

			return response.getWeeklyResults();

		} catch (RetrofitError e) {

			LOG.error("Error retrieving {} league {} weekly results data for week {} : {}",
					year, mflLeagueId, week, e.getMessage());

			throw new MFLServiceException("Error retrieving weekly results data.", e);
		}
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.LeagueService#getStandings(int, java.lang.String, int)
	 */
	@Override
	public List<Standings> getStandings(final int mflLeagueId, final String serverId, final int year) {

		LOG.info("Loading league {} standings for {}", mflLeagueId, CURRENT_YEAR);

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final StandingsResponse standingsResponse = leagueExport.getStandings(mflLeagueId, CURRENT_YEAR);

		if (standingsResponse != null && standingsResponse.getWrapper() != null) {
			return standingsResponse.getWrapper().getStandings();
		}

		return null;
	}

	@Override
	public List<DraftPick> getDraftPicks(final int mflLeagueId, final String serverId, final int year) {

		LOG.info("Loading league {} draft picks for {}", mflLeagueId, year);

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final DraftResultsResponse draftResultsResponse = leagueExport.getDraftResults(mflLeagueId, year);

		/* XXX : lots of NPE issues here */
		if (draftResultsResponse != null && draftResultsResponse.getDraftResults() != null) {
			return draftResultsResponse.getDraftResults().getDrafts().get(0).getPicks();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.tiltedwindmills.fantasy.mfl.services.LeagueService#getFreeAgents(int,
	 * java.lang.String, int)
	 */
	@Override
	public List<String> getFreeAgents(int mflLeagueId, String serverId, int year) {

		LOG.debug("Retrieving free agent IDs for {} league {}", year, mflLeagueId);

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final FreeAgentsResponse freeAgentsResponse = leagueExport.getFreeAgents(mflLeagueId, year);

		if (freeAgentsResponse != null && !CollectionUtils.isEmpty(freeAgentsResponse.getPlayerIds())) {
			return freeAgentsResponse.getPlayerIds();
		}

		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.tiltedwindmills.fantasy.mfl.services.LeagueService#getFreeAgents(org.
	 * tiltedwindmills.fantasy.mfl.model.Position, int, java.lang.String, int)
	 */
	@Override
	public List<String> getFreeAgents(final Position position, final int mflLeagueId, final String serverId, final int year) {

		LOG.debug("Retrieving {} free agent IDs for {} league {}", position, year, mflLeagueId);

		if (position != null) {

			final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
			final FreeAgentsResponse freeAgentsResponse =
					leagueExport.getFreeAgentsByPosition(mflLeagueId, position.getType(), year);

			if (freeAgentsResponse != null && !CollectionUtils.isEmpty(freeAgentsResponse.getPlayerIds())) {
				return freeAgentsResponse.getPlayerIds();
			}
		}

		return new ArrayList<>();
	}
}

package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tiltedwindmills.fantasy.mfl.model.League;
import org.tiltedwindmills.fantasy.mfl.model.LeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftPick;
import org.tiltedwindmills.fantasy.mfl.model.draft.DraftResultsResponse;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResult;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResultWrapper;
import org.tiltedwindmills.fantasy.mfl.model.leaguesearch.SearchLeagueResponse;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringResponse;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringWrapper;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.Matchup;
import org.tiltedwindmills.fantasy.mfl.model.livescoring.TeamScoringDetails;
import org.tiltedwindmills.fantasy.mfl.model.standings.Standings;
import org.tiltedwindmills.fantasy.mfl.model.standings.StandingsResponse;
import org.tiltedwindmills.fantasy.mfl.services.LeagueService;

/**
 * JSON implementation of the {@link LeagueService}
 */
@Service
public final class JsonLeagueServiceImpl extends AbstractJsonServiceImpl implements LeagueService {

	private static final Logger LOG = LoggerFactory.getLogger(JsonLeagueServiceImpl.class);

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

		LOG.info("Loading league {} draft picks for {}", mflLeagueId, CURRENT_YEAR);

		final MflLeagueExport leagueExport = getRestAdapter(serverId).create(MflLeagueExport.class);
		final DraftResultsResponse draftResultsResponse = leagueExport.getDraftResults(mflLeagueId, CURRENT_YEAR);

		/* XXX : lots of NPE issues here */
		if (draftResultsResponse != null && draftResultsResponse.getDraftResults() != null) {
			return draftResultsResponse.getDraftResults().getDrafts().get(0).getPicks();
		}

		return null;
	}
}

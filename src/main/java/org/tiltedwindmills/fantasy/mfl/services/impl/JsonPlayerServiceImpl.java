package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesResponse;
import org.tiltedwindmills.fantasy.mfl.model.injuries.Injury;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScore;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatus;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;
import org.tiltedwindmills.fantasy.mfl.services.PlayerService;

import com.google.common.base.Joiner;

/**
 * Implementation of the Player API operations that uses the JSON MFL API.
 */
@Service
public final class JsonPlayerServiceImpl extends AbstractJsonServiceImpl implements PlayerService {

	private static final Logger LOG = LoggerFactory.getLogger(JsonPlayerServiceImpl.class);

	// no need to be server specific about player ops.
	private static final String SERVER_ID = "";

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getPlayers(java.util.List)
	 */
	@Override
	public List<Player> getPlayers(final List<String> playerIds) {

		final String playerIdsParameter = getPlayerIdParameterFromList(playerIds);

		final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
		final PlayerResponse playerResponse = playerExport.getPlayers(playerIdsParameter, CURRENT_YEAR);

		return playerResponse.getWrapper().getPlayers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getPlayersSinceDate(java.util.Calendar)
	 */
	@Override
	public List<Player> getPlayersSinceDate(final Calendar calendar) {

		// jd - milliseconds calc
		// CHECKSTYLE:OFF
		long unixTime = calendar.getTimeInMillis() / 1000;
		// CHECKSTYLE:ON

		final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
		final PlayerResponse playerResponse = playerExport.getAllPlayersSince(Long.toString(unixTime), CURRENT_YEAR);

		// could be as simple as "no updates since requested date". Nothing to die over.
		if (playerResponse.getError() != null) {
			LOG.warn("No players were retrieved: {} ", playerResponse.getError().getMessage());
			return new ArrayList<Player>();
		}

		// hunky dory. Shoot the list back.
		return playerResponse.getWrapper().getPlayers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getAllPlayers()
	 */
	@Override
	public List<Player> getAllPlayers() {

		final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
		final PlayerResponse playerResponse = playerExport.getAllPlayers(CURRENT_YEAR);

		return playerResponse.getWrapper().getPlayers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getWeeklyScores(int, int, java.lang.String, int)
	 */
	@Override
	public Map<Integer, Double> getWeeklyScores(final int leagueId, final int playerId, final String serverId,
			final int year) {

		final MflPlayerExport playerExport = getRestAdapter(serverId).create(MflPlayerExport.class);
		final PlayerScoresResponse playerResponse = playerExport.getPlayerScores(leagueId, Integer.toString(playerId),
				"", year);

		final List<PlayerScore> apiScores = playerResponse.getWrapper().getPlayerScores();

		// fill our map, as we can throw away the player ID element of the returned data.
		final Map<Integer, Double> playerScores = new TreeMap<Integer, Double>();
		for (PlayerScore apiScore : apiScores) {

			// will be blank if didn't play. Leave these off the list.
			if (!StringUtils.isBlank(apiScore.getScore())) {

				// get the values we care about, setting to 0 as default.
				final Integer week = NumberUtils.toInt(apiScore.getWeek(), 0);
				final Double score = NumberUtils.toDouble(apiScore.getScore(), 0.0);

				playerScores.put(week, score);
			}
		}

		return playerScores;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getMultiplePlayersScores(int, java.util.List,
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public Map<Integer, Double> getMultiplePlayersScores(final int leagueId, final List<Integer> playerIds,
			final String week, final String serverId, final int year) {

		// turn our list of player IDs into a comma separated string.
		final String playerParameter = getPlayerIdParameterFromList(playerIds);

		final MflPlayerExport playerExport = getRestAdapter(serverId).create(MflPlayerExport.class);
		final PlayerScoresResponse playerResponse = playerExport.getPlayerScores(leagueId, playerParameter, week, year);

		final List<PlayerScore> apiScores = playerResponse.getWrapper().getPlayerScores();

		// fill our map, throwing away the week data.
		final Map<Integer, Double> playerScores = new TreeMap<Integer, Double>();
		for (PlayerScore apiScore : apiScores) {

			// will be blank if didn't play. Leave these off the list.
			if (!StringUtils.isBlank(apiScore.getScore())) {

				// get the values we care about, setting to 0 as default.
				final Integer playerId = apiScore.getPlayerId();
				final Double score = NumberUtils.toDouble(apiScore.getScore(), 0.0);

				playerScores.put(playerId, score);
			}
		}

		return playerScores;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getAllInjuries(int, int)
	 */
	@Override
	public List<Injury> getAllInjuries(final int week, final int year) {

		final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
		final InjuriesResponse injuriesResponse = playerExport.getInjuries(week, year);

		for (Injury injury : injuriesResponse.getInjuries().getInjuries()) {
			injury.setWeek(injuriesResponse.getInjuries().getWeek());
		}

		return injuriesResponse.getInjuries().getInjuries();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getPlayerStatus(int, java.util.List,
	 * java.lang.String, int)
	 */
	@Override
	public Map<Integer, String> getPlayerStatus(final int leagueId, final Set<String> playerIds,
			final String serverId, final int currentYear) {

		final Map<Integer, String> playerStatuses = new HashMap<Integer, String>();

		// if no players requested, just return the blank array.
		if (playerIds == null || playerIds.isEmpty()) {
			return playerStatuses;
		}

		// turn our list of player IDs into a comma separated string.
		final String playerParameter = getPlayerIdParameterFromList(playerIds);

		final MflPlayerExport playerExport = getRestAdapter(serverId).create(MflPlayerExport.class);
		final PlayerStatusResponse playerResponse = playerExport
				.getPlayerStatus(leagueId, playerParameter, currentYear);

		// MFL API only returns a single element for a one-player request, so manage that difference here.
		// TODO : still necessary?
		if (playerIds.size() == 1) {

			final PlayerStatus playerStatus = playerResponse.getPlayerStatus();
			playerStatuses.put(playerStatus.getPlayerId(), playerStatus.getStatus());
		}

		else {

			final List<PlayerStatus> apiStatuses = playerResponse.getWrapper().getPlayerStatuses();
			for (PlayerStatus apiStatus : apiStatuses) {
				playerStatuses.put(apiStatus.getPlayerId(), apiStatus.getStatus());
			}
		}

		return playerStatuses;
	}

	// constructs a comma separated array suitable for querystring parameter from a given list.
	private String getPlayerIdParameterFromList(final Collection<?> playerIds) {

		return Joiner.on(",").skipNulls().join(playerIds);
	}
}

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
import org.springframework.util.CollectionUtils;
import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesResponse;
import org.tiltedwindmills.fantasy.mfl.model.injuries.Injury;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScore;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerAvailabilityStatus;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;
import org.tiltedwindmills.fantasy.mfl.services.PlayerService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;

import com.google.common.base.Joiner;

/**
 * Implementation of the Player API operations that uses the JSON MFL API.
 *
 * @author John Daniel
 */
@Service
public final class JsonPlayerServiceImpl extends AbstractJsonServiceImpl implements PlayerService {

	private static final Logger LOG = LoggerFactory.getLogger(JsonPlayerServiceImpl.class);

	// service names for validation routines
	private static final String INJURY_SERVICE = "injury";
	private static final String PLAYER_AVAILABILITY_SERVICE = "player availability";
	private static final String PLAYER_SCORES_SERVICE = "player scores";

	// no need to be server specific about generic player ops.
	private static final String SERVER_ID = "";


	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getPlayers(java.util.List)
	 */
	@Override
	public List<Player> getPlayers(final List<String> playerIds) {

		final String playerIdsParameter = getPlayerIdParameterFromList(playerIds);

		if (StringUtils.isBlank(playerIdsParameter)) {
			LOG.warn("Invalid parameters for retrieving players.  Found '{}' list.", playerIds);
			throw new MFLServiceException("Cannot retrieve player information without IDs.");
		}

		try {

			final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
			final PlayerResponse playerResponse = playerExport.getPlayers(playerIdsParameter, CURRENT_YEAR);

			if (playerResponse == null || playerResponse.getWrapper() == null) {
				LOG.error("Invalid response retrieving players for IDs '{}'.", playerIds);
				throw new MFLServiceException("Invalid response retrieving players with IDs : " + playerIds);
			}

			return playerResponse.getWrapper().getPlayers();

		} catch (RetrofitError e) {
			LOG.error("Error retrieving player data for IDs '{}' : {}", playerIds, e.getMessage());
			throw new MFLServiceException("Error retrieving player data.", e);
		}
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

		try {

			final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
			final PlayerResponse playerResponse = playerExport.getAllPlayers(CURRENT_YEAR);

			if (playerResponse == null || playerResponse.getWrapper() == null) {
				LOG.error("Invalid response retrieving all players.");
				throw new MFLServiceException("Invalid response retrieving all players");
			}

			return playerResponse.getWrapper().getPlayers();

		} catch (RetrofitError e) {
			LOG.error("Error retrieving all player data: {}", e.getMessage());
			throw new MFLServiceException("Error retrieving all player data", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getWeeklyScores(int, int, java.lang.String, int)
	 */
	@Override
	public Map<Integer, Double> getWeeklyScores(final int leagueId, final int playerId, final String serverId,
			final int year) {

		validateLeagueId(leagueId, PLAYER_SCORES_SERVICE);
		validateServerId(serverId, PLAYER_SCORES_SERVICE);
		validateYear(year, PLAYER_SCORES_SERVICE);

		try {

			if (playerId < 0) {
				LOG.warn("Player ID {} cannot be used to retrieve player scores.", playerId);
				throw new MFLServiceException("Cannot retrieve player score information without a valid ID.");
			}

			final MflPlayerExport playerExport = getRestAdapter(serverId).create(MflPlayerExport.class);
			final PlayerScoresResponse playerResponse =
					playerExport.getPlayerScores(leagueId, Integer.toString(playerId), "", year);

			if (playerResponse == null || playerResponse.getWrapper() == null) {
				LOG.error("Invalid response retrieving {} player id {} scores.", year, playerId);
				throw new MFLServiceException("Invalid response retrieving " + year + " player id " + playerId);
			}

			final List<PlayerScore> apiScores = playerResponse.getWrapper().getPlayerScores();

			// fill our map, as we can throw away the player ID element of the returned data.
			final Map<Integer, Double> playerScores = new TreeMap<Integer, Double>();
			if (CollectionUtils.isEmpty(apiScores)) {
				LOG.warn("Found empty player scores list.  Ignoring.");
			} else {
				for (PlayerScore apiScore : apiScores) {
					if (apiScore == null) {
						LOG.warn("Found null player score.  Ignoring.");
					} else {

						// value will be blank if didn't play. Leave these off the list.
						if (!StringUtils.isBlank(apiScore.getScore())) {

							// get the values we care about, setting to 0 as default.
							final Integer week = NumberUtils.toInt(apiScore.getWeek(), 0);
							final Double score = NumberUtils.toDouble(apiScore.getScore(), 0.0);

							playerScores.put(week, score);
						}
					}
				}
			}

			return playerScores;

		} catch (RetrofitError e) {
			LOG.error("Error retrieving all player data: {}", e.getMessage());
			throw new MFLServiceException("Error retrieving all player data", e);
		}
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

		validateWeek(week, INJURY_SERVICE);
		validateYear(year, INJURY_SERVICE);

		try {
			final MflPlayerExport playerExport = getRestAdapter(SERVER_ID).create(MflPlayerExport.class);
			final InjuriesResponse injuriesResponse = playerExport.getInjuries(week, year);

			if (injuriesResponse == null || injuriesResponse.getWrapper() == null) {
				LOG.error("Invalid response retrieving injuries for {} week {}.", year, week);
				throw new MFLServiceException("Invalid response retrieving injuries in " + year + " week " + week);
			}

			// set the week element manually, as its returned as an aggregate from MFL.
			for (Injury injury : injuriesResponse.getWrapper().getInjuries()) {

				// TODO : make sure we have test for this functionality
				injury.setWeek(injuriesResponse.getWrapper().getWeek());
			}

			return injuriesResponse.getWrapper().getInjuries();

		} catch (RetrofitError e) {

			LOG.error("Error retrieving {} week {} injuries : {}", year, week, e.getMessage());
			throw new MFLServiceException("Error retrieving player injury data.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.tiltedwindmills.fantasy.mfl.services.PlayerService#getPlayerStatus(int, java.util.List,
	 * java.lang.String, int)
	 */
	@Override
	public Map<Integer, String> getPlayerAvailability(final int leagueId, final Set<String> playerIds,
			final String serverId, final int year) {

		validateLeagueId(leagueId, PLAYER_AVAILABILITY_SERVICE);
		validateServerId(serverId, PLAYER_AVAILABILITY_SERVICE);
		validateYear(year, PLAYER_AVAILABILITY_SERVICE);

		// turn our list of player IDs into a comma separated string.
		final String playerIdsParameter = getPlayerIdParameterFromList(playerIds);

		if (StringUtils.isBlank(playerIdsParameter)) {
			LOG.warn("Invalid parameters for retrieving player status.  Found '{}' list.", playerIds);
			throw new MFLServiceException("Cannot retrieve player status information without IDs.");
		}

		try {
			final MflPlayerExport playerExport = getRestAdapter(serverId).create(MflPlayerExport.class);
			final PlayerStatusResponse response = playerExport
					.getPlayerStatus(leagueId, playerIdsParameter, year);

			if (response == null) {
				LOG.error("Invalid response retrieving player status for IDs '{}'.", playerIds);
				throw new MFLServiceException("Invalid response retrieving player status");
			}

			if (response.getError() != null) {
				LOG.error("MFL reported error retrieving player status for IDs '{}'.", playerIds);
				throw new MFLServiceException("Error retrieving player status : " + response.getError().getMessage());
			}

			return mapPlayerStatus(response, playerIds.size() > 1);

		} catch (RetrofitError e) {

			LOG.error("Error retrieving {} league {} player status data for IDs '{}' : {}",
					year, leagueId, playerIds, e.getMessage());

			throw new MFLServiceException("Error retrieving player availability data.", e);
		}
	}

	private Map<Integer, String> mapPlayerStatus(final PlayerStatusResponse response, final boolean isMultiplePlayers) {

		final Map<Integer, String> playerStatuses = new HashMap<Integer, String>();

		// MFL API only returns a single element for a one-player request, so manage that difference here.
		if (isMultiplePlayers) {

			if (response.getWrapper() == null) {
				throw new MFLServiceException("Invalid wrapper response retrieving player status");
			}

			final List<PlayerAvailabilityStatus> apiStatuses = response.getWrapper().getPlayerStatuses();
			if (CollectionUtils.isEmpty(apiStatuses)) {
				LOG.warn("Found empty player status list.  Ignoring.");
			} else {
				for (PlayerAvailabilityStatus apiStatus : apiStatuses) {
					if (apiStatus == null) {
						LOG.warn("Found null player status.  Ignoring.");
					} else {
						playerStatuses.put(apiStatus.getPlayerId(), apiStatus.getStatus());
					}
				}
			}

		} else {
			final PlayerAvailabilityStatus playerAvailabilityStatus = response.getPlayerAvailabilityStatus();
			if (playerAvailabilityStatus == null) {
				LOG.warn("Found null single player status.  Ignoring.");
			} else {
				playerStatuses.put(playerAvailabilityStatus.getPlayerId(), playerAvailabilityStatus.getStatus());
			}
		}

		return playerStatuses;
	}


	/** constructs a comma separated array suitable for querystring parameter from a given collection. */
	private String getPlayerIdParameterFromList(final Collection<?> playerIds) {

		if (CollectionUtils.isEmpty(playerIds)) {
			return "";
		}
		return Joiner.on(",").skipNulls().join(playerIds);
	}
}

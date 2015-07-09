package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.tiltedwindmills.fantasy.mfl.RetrofitUtils.getDummyHttpError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mockit.Capturing;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.JsonDataConverter;
import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesResponse;
import org.tiltedwindmills.fantasy.mfl.model.injuries.Injury;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerAvailabilityStatus;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScore;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresWrapper;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusWrapper;
import org.tiltedwindmills.fantasy.mfl.services.PlayerService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;

/**
 * Tests for {@link org.tiltedwindmills.fantasy.mfl.services.impl.JsonPlayerServiceImpl}.
 *
 * @author John Daniel
 */
public class JsonPlayerServiceImplTest {

	// TODO : need to add parameter tests. e.g. don't think any of these are testing league or server ID validations.

	// constants
	private static final int RANDOM_LEAGUE_ID = 11111;

	// mock any implementers of the Retrofit interface
	@Capturing private MflPlayerExport mflPlayerExport;

	/*------------------------------------------------ getPlayers ------------------------------------------------*/

	@Test
	public void getPlayersTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayers(anyString, anyInt); returns(JsonDataConverter.players("multiple-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		List<Player> players = playerService.getPlayers(Arrays.asList("1234","5678"));

		assertThat(players, is(not(nullValue())));
		assertThat(players.size(), is(2));
		assertThat(players.get(0), is(not(nullValue())));
		assertThat(players.get(0).getName(), is("Brees, Drew"));
	}

	@Test
	public void getPlayersTest_NoResults() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayers(anyString, anyInt); returns(JsonDataConverter.players("no-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		List<Player> players = playerService.getPlayers(Arrays.asList("1234","5678"));

		assertThat(players, is(not(nullValue())));
		assertThat(players.size(), is(0));
	}

	@Test
	public void getPlayersTest_NullPlayerIds() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayers(null);

			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			// expected
		}

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayers(anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getPlayersTest_EmptyPlayerIds() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayers(new ArrayList<String>());

			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			// expected
		}

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayers(anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getPlayersTest_HttpError() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayers(anyString, anyInt); result = getDummyHttpError();
		}};

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayers(Arrays.asList("1234","5678"));
			fail("should have thrown exception.");

		} catch (MFLServiceException e) {
			// expected behavior.  Confirm root cause is propagated.
			assertThat(e.getCause(), instanceOf(RetrofitError.class));
		}
	}

	@Test(expected = MFLServiceException.class)
	public void getPlayersTest_NullResponse() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayers(anyString, anyInt); returns(null);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayers(Arrays.asList("1234","5678"));
	}

	@Test(expected = MFLServiceException.class)
	public void getPlayersTest_NullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayers(anyString, anyInt); returns(new PlayerResponse());
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayers(Arrays.asList("1234","5678"));
	}

	/*----------------------------------------------- getAllPlayers ----------------------------------------------*/

	@Test
	public void getAllPlayersTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getAllPlayers(anyInt); returns(JsonDataConverter.players("multiple-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		List<Player> players = playerService.getAllPlayers();

		assertThat(players, is(not(nullValue())));
		assertThat(players.size(), is(2));
		assertThat(players.get(0), is(not(nullValue())));
		assertThat(players.get(0).getName(), is("Brees, Drew"));
	}

	@Test
	public void getAllPlayersTest_NoResults() {

		new NonStrictExpectations() {{
			mflPlayerExport.getAllPlayers(anyInt); returns(JsonDataConverter.players("no-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		List<Player> players = playerService.getAllPlayers();

		assertThat(players, is(not(nullValue())));
		assertThat(players.size(), is(0));
	}

	@Test
	public void getAllPlayersTest_HttpError() {

		new NonStrictExpectations() {{
			mflPlayerExport.getAllPlayers(anyInt); result = getDummyHttpError();
		}};

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getAllPlayers();
			fail("should have thrown exception.");

		} catch (MFLServiceException e) {
			// expected behavior.  Confirm root cause is propagated.
			assertThat(e.getCause(), instanceOf(RetrofitError.class));
		}
	}

	@Test(expected = MFLServiceException.class)
	public void getAllPlayersTest_NullResponse() {

		new NonStrictExpectations() {{
			mflPlayerExport.getAllPlayers(anyInt); returns(null);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getAllPlayers();
	}

	@Test(expected = MFLServiceException.class)
	public void getAllPlayersTest_NullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getAllPlayers(anyInt); returns(new PlayerResponse());
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getAllPlayers();
	}


	/*---------------------------------------------- getWeeklyScores ---------------------------------------------*/

	@Test
	public void getWeeklyScoresTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt);
					returns(JsonDataConverter.playerScores("full-schedule"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Map<Integer, Double> playerScoresMap = playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);

		assertThat(playerScoresMap, is(not(nullValue())));
		assertThat(playerScoresMap.size(), is(16));

		// before bye week
		assertThat(playerScoresMap.containsKey(1), is(true));
		assertThat(playerScoresMap.get(1), is(30.7));

		// bye week
		assertThat(playerScoresMap.containsKey(10), is(false));

		// after bye week
		assertThat(playerScoresMap.containsKey(11), is(true));
		assertThat(playerScoresMap.get(11), is(23.62));
	}

	@Test
	public void getWeeklyScoresTest_InjuredPlayer() {

		// Arian Foster missed 3 weeks due to injury.  Make sure they don't show in the scoring list.

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt);
					returns(JsonDataConverter.playerScores("injured-player"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Map<Integer, Double> playerScoresMap = playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);

		assertThat(playerScoresMap, is(not(nullValue())));
		assertThat(playerScoresMap.size(), is(13));

		// validate injured weeks are missing
		assertThat(playerScoresMap.containsKey(3), is(false));
		assertThat(playerScoresMap.containsKey(11), is(false));
		assertThat(playerScoresMap.containsKey(12), is(false));

		// before injuries
		assertThat(playerScoresMap.containsKey(1), is(true));
		assertThat(playerScoresMap.get(1), is(11d));

		// after injuries
		assertThat(playerScoresMap.containsKey(4), is(true));
		assertThat(playerScoresMap.get(4), is(9.6));
	}

	@Test
	public void getWeeklyScoresTest_ZeroScoreWeek() {

		// Jimmy Graham didn't record a catch weeks 7 or 13.  Make sure these do show up in report.

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt);
					returns(JsonDataConverter.playerScores("week-without-scoring"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Map<Integer, Double> playerScoresMap = playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);

		assertThat(playerScoresMap, is(not(nullValue())));
		assertThat(playerScoresMap.size(), is(16));

		// validate injured weeks are present
		assertThat(playerScoresMap.containsKey(7), is(true));
		assertThat(playerScoresMap.get(7), is(0d));
		assertThat(playerScoresMap.containsKey(13), is(true));
		assertThat(playerScoresMap.get(13), is(0d));
	}

	@Test(expected = MFLServiceException.class)
	public void getWeeklyScoresTest_InvalidPlayerId() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt);
					returns(JsonDataConverter.playerScores("full-schedule"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getWeeklyScores(RANDOM_LEAGUE_ID, -1, "1", 2015);
	}

	@Test(expected = MFLServiceException.class)
	public void getWeeklyScoresTest_EarlyYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 1979);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); times = 0;
		}};
	}

	@Test(expected = MFLServiceException.class)
	public void getWeeklyScoresTest_FutureYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", nextYear);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getWeeklyScoresTest_HttpError() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); result = getDummyHttpError();
		}};

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);
			fail("should have thrown exception.");

		} catch (MFLServiceException e) {
			// expected behavior.  Confirm root cause is propagated.
			assertThat(e.getCause(), instanceOf(RetrofitError.class));
		}
	}

	@Test(expected = MFLServiceException.class)
	public void getWeeklyScoresTest_NullResponse() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); returns(null);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);
	}

	@Test(expected = MFLServiceException.class)
	public void getWeeklyScoresTest_NullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); returns(new PlayerScoresResponse());
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);
	}

	@Test
	public void getWeeklyScoresTest_UnsetScoresList() {

		new NonStrictExpectations() {{

			PlayerScoresResponse playerScoresResponse = new PlayerScoresResponse();
			playerScoresResponse.setWrapper(new PlayerScoresWrapper());  // no scores are set
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); returns(playerScoresResponse);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Map<Integer, Double> playerScoreMap = playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);

		assertThat(playerScoreMap, is(not(nullValue())));
		assertThat(playerScoreMap.size(), is(0));
	}

	@Test
	public void getWeeklyScoresTest_NullEntryInScoresList() {

		new NonStrictExpectations() {{

			PlayerScore playerScore = new PlayerScore();
			playerScore.setPlayerId(10695);
			playerScore.setScore("12.3");
			playerScore.setWeek("5");

			PlayerScoresResponse playerScoresResponse = new PlayerScoresResponse();
			playerScoresResponse.setWrapper(new PlayerScoresWrapper());
			playerScoresResponse.getWrapper().setPlayerScores(Arrays.asList(null, playerScore));
			mflPlayerExport.getPlayerScores(anyInt, anyString, anyString, anyInt); returns(playerScoresResponse);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Map<Integer, Double> playerScoreMap = playerService.getWeeklyScores(RANDOM_LEAGUE_ID, 1234, "1", 2015);

		// make sure the null score didn't screw up the rest of the processing
		assertThat(playerScoreMap, is(not(nullValue())));
		assertThat(playerScoreMap.size(), is(1));
		assertThat(playerScoreMap.get(5), is(12.3));
	}


	/*----------------------------------------------- getAllInjuries -----------------------------------------------*/


	@Test
	public void getAllInjuriesTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getInjuries(anyInt, anyInt); returns(JsonDataConverter.injuries("injuries"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		List<Injury> injuries = playerService.getAllInjuries(1, 2015);

		assertThat(injuries, is(not(nullValue())));
		assertThat(injuries.size(), is(144));
		assertThat(injuries.get(0), is(not(nullValue())));
		assertThat(injuries.get(0).getPlayerId(), is(10048));
		assertThat(injuries.get(0).getStatus(), is("Probable"));
		assertThat(injuries.get(0).getDetails(), is("Knee"));
		assertThat(injuries.get(0).getWeek(), is(1));
	}

	@Test
	public void getAllInjuriesTest_InvalidWeekProvided() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getAllInjuries(24, 2015);

			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			// expected
		}

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getInjuries(anyInt, anyInt); times = 0;
		}};
	}

	@Test(expected = MFLServiceException.class)
	public void getAllInjuriesTest_EarlyYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getAllInjuries(1, 1979);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}

	@Test(expected = MFLServiceException.class)
	public void getAllInjuriesTest_FutureYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		playerService.getAllInjuries(1, nextYear);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getAllInjuriesTest_HttpError() {

		new NonStrictExpectations() {{
			mflPlayerExport.getInjuries(anyInt, anyInt); result = getDummyHttpError();
		}};

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getAllInjuries(1, 2015);
			fail("should have thrown exception.");

		} catch (MFLServiceException e) {
			// expected behavior.  Confirm root cause is propagated.
			assertThat(e.getCause(), instanceOf(RetrofitError.class));
		}
	}

	@Test(expected = MFLServiceException.class)
	public void getAllInjuriesTest_NullResponse() {

		new NonStrictExpectations() {{
			mflPlayerExport.getInjuries(anyInt, anyInt); returns(null);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getAllInjuries(1, 2015);
	}

	@Test(expected = MFLServiceException.class)
	public void getAllInjuriesTest_NullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getInjuries(anyInt, anyInt); returns(new InjuriesResponse());
		}};

		// must send multiple player IDs to get the wrapper.
		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getAllInjuries(1, 2015);
	}


	/*-------------------------------------------- getPlayerAvailability -------------------------------------------*/

	@Test
	public void getPlayerAvailabilityTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt);
						returns(JsonDataConverter.playerStatus("multiple-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234","5678"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, playerIds, "1", 2015);

		assertThat(playerAvailabilityMap, is(not(nullValue())));
		assertThat(playerAvailabilityMap.size(), is(4));
		assertThat(playerAvailabilityMap.containsKey(11192), is(true));
		assertThat(playerAvailabilityMap.get(11192), is("New Orleans Saints - NS"));
		assertThat(playerAvailabilityMap.containsKey(10998), is(true));
		assertThat(playerAvailabilityMap.get(10998), is("Free Agent"));
		assertThat(playerAvailabilityMap.containsKey(10998), is(true));
		assertThat(playerAvailabilityMap.get(99999), is("League Does Not Use This Position"));
	}

	@Test
	public void getPlayerAvailabilityTest_SinglePlayer() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt);
						returns(JsonDataConverter.playerStatus("single-player"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, playerIds, "1", 2015);

		assertThat(playerAvailabilityMap, is(not(nullValue())));
		assertThat(playerAvailabilityMap.size(), is(1));
		assertThat(playerAvailabilityMap.containsKey(11192), is(true));
		assertThat(playerAvailabilityMap.get(11192), is("New Orleans Saints - NS"));
	}

	@Test
	public void getPlayerAvailabilityTest_NoPlayerIdsProvided() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt);
						returns(JsonDataConverter.playerStatus("invalid-request"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();

		try {
			playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			assertThat(e.getMessage(), is("Error retrieving player status : Error - No Valid Player IDs!"));
		}
	}

	@Test
	public void getPlayerAvailabilityTest_NullPlayerIds() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, null, "1", 2015);

			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			// expected
		}

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getPlayerAvailabilityTest_EmptyPlayerIds() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<String>(), "1", 2015);

			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			// expected
		}

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}

	@Test(expected = MFLServiceException.class)
	public void getAvailabilityPlayerTest_EarlyYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", 1979);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}


	@Test(expected = MFLServiceException.class)
	public void getAvailabilityPlayerTest_FutureYear() {

		PlayerService playerService = new JsonPlayerServiceImpl();
		int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", nextYear);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}

	@Test
	public void getPlayerAvailabilityTest_HttpError() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); result = getDummyHttpError();
		}};

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
			fail("should have thrown exception.");

		} catch (MFLServiceException e) {
			// expected behavior.  Confirm root cause is propagated.
			assertThat(e.getCause(), instanceOf(RetrofitError.class));
		}
	}

	@Test(expected = MFLServiceException.class)
	public void getPlayerAvailabilityTest_NullResponse() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(null);
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
	}

	@Test
	public void getAvailabilityPlayerTest_SinglePlayerNullStatus() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(new PlayerStatusResponse());
		}};

		// only send one player ID.
		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, playerIds, "1", 2015);

		assertThat(playerAvailabilityMap, is(not(nullValue())));
		assertThat(playerAvailabilityMap.size(), is(0));
	}

	@Test(expected = MFLServiceException.class)
	public void getAvailabilityPlayerTest_MultiplePlayersNullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(new PlayerStatusResponse());
		}};

		// must send multiple player IDs to get the wrapper.
		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
	}

	@Test
	public void getAvailabilityPlayerTest_MultiplePlayersNullStatusList() {

		new NonStrictExpectations() {{
			PlayerStatusResponse playerStatusResponse = new PlayerStatusResponse();
			playerStatusResponse.setWrapper(new PlayerStatusWrapper());
			assertThat(playerStatusResponse.getWrapper().getPlayerStatuses(), is(nullValue()));
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(playerStatusResponse);
		}};

		// send multiple player IDs
		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234","5678"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, playerIds, "1", 2015);

		assertThat(playerAvailabilityMap, is(not(nullValue())));
		assertThat(playerAvailabilityMap.size(), is(0));
	}

	@Test
	public void getAvailabilityPlayerTest_MultiplePlayersNullStatusInList() {

		new NonStrictExpectations() {{
			PlayerAvailabilityStatus playerAvailabilityStatus = new PlayerAvailabilityStatus();
			playerAvailabilityStatus.setPlayerId(10695);
			playerAvailabilityStatus.setStatus("Foo");

			PlayerStatusResponse playerStatusResponse = new PlayerStatusResponse();
			playerStatusResponse.setWrapper(new PlayerStatusWrapper());
			playerStatusResponse.getWrapper().setPlayerStatuses(Arrays.asList(null, playerAvailabilityStatus));

			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(playerStatusResponse);
		}};

		// send multiple player IDs
		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234","5678"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(RANDOM_LEAGUE_ID, playerIds, "1", 2015);

		// make sure the null status didn't screw up the rest of the processing
		assertThat(playerAvailabilityMap, is(not(nullValue())));
		assertThat(playerAvailabilityMap.size(), is(1));
		assertThat(playerAvailabilityMap.get(10695), is("Foo"));
	}
}

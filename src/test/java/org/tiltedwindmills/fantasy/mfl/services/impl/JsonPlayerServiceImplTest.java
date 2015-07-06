package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusResponse;
import org.tiltedwindmills.fantasy.mfl.services.PlayerService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.services.impl.JsonPlayerServiceImpl}.
 *
 * @author John Daniel
 */
public class JsonPlayerServiceImplTest {

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


	/*-------------------------------------------- getPlayerAvailability -------------------------------------------*/

	@Test
	public void getPlayerAvailabilityTest() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt);
						returns(JsonDataConverter.playerStatus("multiple-players"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();
		Set<String> playerIds = new HashSet<>(Arrays.asList("1234","5678"));
		Map<Integer, String> playerAvailabilityMap = playerService.getPlayerAvailability(11111, playerIds, "1", 2015);


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
	public void getPlayerAvailabilityTest_NoPlayerIdsProvided() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt);
						returns(JsonDataConverter.playerStatus("invalid-request"));
		}};

		PlayerService playerService = new JsonPlayerServiceImpl();

		try {
			playerService.getPlayerAvailability(11111, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
			fail("should have thrown exception");

		} catch (MFLServiceException e) {
			assertThat(e.getMessage(), is("Error retrieving player status : Error - No Valid Player IDs!"));
		}
	}

	@Test
	public void getPlayerAvailabilityTest_NullPlayerIds() {

		try {
			PlayerService playerService = new JsonPlayerServiceImpl();
			playerService.getPlayerAvailability(11111, null, "1", 2015);

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
			playerService.getPlayerAvailability(11111, new HashSet<String>(), "1", 2015);

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

		// must send multiple player IDs to get the wrapper.
		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayerAvailability(1, new HashSet<>(Arrays.asList("1234","5678")), "1", 1979);

		new Verifications() {{
			// Verify no calls to the service API occurred
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); times = 0;
		}};
	}


	@Test(expected = MFLServiceException.class)
	public void getAvailabilityPlayerTest_FutureYear() {

		// must send multiple player IDs to get the wrapper.
		PlayerService playerService = new JsonPlayerServiceImpl();
		int nextYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		playerService.getPlayerAvailability(1, new HashSet<>(Arrays.asList("1234","5678")), "1", nextYear);

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
			playerService.getPlayerAvailability(11111, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
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
		playerService.getPlayerAvailability(1, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
	}

	@Test(expected = MFLServiceException.class)
	public void getAvailabilityPlayerTest_NullWrapper() {

		new NonStrictExpectations() {{
			mflPlayerExport.getPlayerStatus(anyInt, anyString, anyInt); returns(new PlayerStatusResponse());
		}};

		// must send multiple player IDs to get the wrapper.
		PlayerService playerService = new JsonPlayerServiceImpl();
		playerService.getPlayerAvailability(1, new HashSet<>(Arrays.asList("1234","5678")), "1", 2015);
	}




	/** Retrieves a silly generic error */
	private RetrofitError getDummyHttpError() {
		Response response = new Response("some url", 500, "some reason", new ArrayList<Header>(), null);
		RetrofitError error = RetrofitError.httpError("someUrl", response, null, null);
		return error;
	}
}

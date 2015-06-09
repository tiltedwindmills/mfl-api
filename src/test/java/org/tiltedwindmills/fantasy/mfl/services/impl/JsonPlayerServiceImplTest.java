package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import mockit.Capturing;
import mockit.NonStrictExpectations;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.JsonDataConverter;
import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
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

			Response response = new Response("some url", 500, "some reason", new ArrayList<Header>(), null);
			RetrofitError error = RetrofitError.httpError("someUrl", response, null, null);
			mflPlayerExport.getAllPlayers(anyInt); result = error;
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
}

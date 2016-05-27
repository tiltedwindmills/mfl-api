package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.JsonDataConverter;
import org.tiltedwindmills.fantasy.mfl.model.Position;
import org.tiltedwindmills.fantasy.mfl.model.freeagents.FreeAgentsResponse;
import org.tiltedwindmills.fantasy.mfl.services.LeagueService;

import mockit.Capturing;
import mockit.NonStrictExpectations;


public class JsonLeagueServiceImplTest_FreeAgents {

	// constants
	private static final int RANDOM_LEAGUE_ID = 11111;
	private static final int RANDOM_YEAR = 2015;
	private static final String RANDOM_SERVER_ID = "1";

	// mock any implementers of the Retrofit interface
	@Capturing private MflLeagueExport mflLeagueExport;


	/*------------------------------------------------- getFreeAgents ----------------------------------------------*/

	@Test
	public void getFreeAgentsTest() {

		new NonStrictExpectations() {{
			FreeAgentsResponse response = JsonDataConverter.freeAgents("free-agents");
			mflLeagueExport.getFreeAgents(anyInt, anyInt); returns(response);
		}};

		LeagueService leagueService = new JsonLeagueServiceImpl();
		List<String> freeAgentIds = leagueService.getFreeAgents(RANDOM_LEAGUE_ID, RANDOM_SERVER_ID, RANDOM_YEAR);

		assertThat(freeAgentIds, is(not(nullValue())));
		assertThat(freeAgentIds, hasSize(1296));
	}

	@Test
	public void getFreeAgents_TestPosition() {

		// little weird in that we're using the same MFL export to test this, but for now we'll assume that those
		// guys don't do anything too wrong.

		new NonStrictExpectations() {{
			FreeAgentsResponse response = JsonDataConverter.freeAgents("free-agents");
			mflLeagueExport.getFreeAgentsByPosition(anyInt, anyString, anyInt); returns(response);
		}};

		LeagueService leagueService = new JsonLeagueServiceImpl();
		List<String> freeAgentIds =
				leagueService.getFreeAgents(Position.QUARTERBACK, RANDOM_LEAGUE_ID, RANDOM_SERVER_ID, RANDOM_YEAR);

		assertThat(freeAgentIds, is(not(nullValue())));
		assertThat(freeAgentIds, hasSize(1296));
	}

	@Test
	public void getFreeAgents_TestNullPosition() {

		new NonStrictExpectations() {{
			FreeAgentsResponse response = JsonDataConverter.freeAgents("free-agents");
			mflLeagueExport.getFreeAgents(anyInt, anyInt); returns(response);
		}};

		LeagueService leagueService = new JsonLeagueServiceImpl();
		List<String> freeAgentIds = leagueService.getFreeAgents(null, RANDOM_LEAGUE_ID, RANDOM_SERVER_ID, RANDOM_YEAR);

		assertThat(freeAgentIds, is(not(nullValue())));
		assertThat(freeAgentIds, hasSize(0));
	}
}

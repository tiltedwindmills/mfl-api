package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.livescoring.LiveScoringWrapper}.
 *
 * @author John Daniel
 */
public class LiveScoringWrapperTest {

	@Test
	public void getMatchupsTest() {

		LiveScoringWrapper wrapper = new LiveScoringWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setMatchups(null);
		assertThat(wrapper.getMatchups(), is(emptyCollectionOf(Matchup.class)));
	}

	@Test
	public void getMatchupsTest_NoOverwrite() {

		TeamScoringDetails teamScoringDetails = new TeamScoringDetails();
		teamScoringDetails.setFranchiseId("0001");

		Matchup matchup = new Matchup();
		matchup.setTeams(Arrays.asList(teamScoringDetails));

		LiveScoringWrapper wrapper = new LiveScoringWrapper();
		wrapper.setMatchups(Arrays.asList(matchup));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getMatchups(), is(not(nullValue())));
		assertThat(wrapper.getMatchups().size(), is(1));
		assertThat(wrapper.getMatchups().get(0), is(not(nullValue())));
		assertThat(wrapper.getMatchups().get(0).getTeams(), is(not(nullValue())));
		assertThat(wrapper.getMatchups().get(0).getTeams().size(), is(1));
		assertThat(wrapper.getMatchups().get(0).getTeams().get(0), is(not(nullValue())));
		assertThat(wrapper.getMatchups().get(0).getTeams().get(0).getFranchiseId(), is("0001"));
	}

	@Test
	public void getTeamsWithoutMatchupTest() {

		LiveScoringWrapper wrapper = new LiveScoringWrapper();

		wrapper.setTeamsWithoutMatchup(null);
		assertThat(wrapper.getTeamsWithoutMatchup(), is(emptyCollectionOf(TeamScoringDetails.class)));
	}

	@Test
	public void getTeamsWithoutMatchupTest_NoOverwrite() {

		TeamScoringDetails teamScoringDetails = new TeamScoringDetails();
		teamScoringDetails.setFranchiseId("0001");

		LiveScoringWrapper wrapper = new LiveScoringWrapper();
		wrapper.setTeamsWithoutMatchup(Arrays.asList(teamScoringDetails));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getTeamsWithoutMatchup(), is(not(nullValue())));
		assertThat(wrapper.getTeamsWithoutMatchup().size(), is(1));
		assertThat(wrapper.getTeamsWithoutMatchup().get(0), is(not(nullValue())));
		assertThat(wrapper.getTeamsWithoutMatchup().get(0).getFranchiseId(), is("0001"));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.livescoring.Matchup}.
 *
 * @author John Daniel
 */
public class MatchupTest {

	@Test
	public void getMatchupsTest() {

		Matchup matchup = new Matchup();

		// set the value null, then immediately confirm its not returned that way.
		matchup.setTeams(null);
		assertThat(matchup.getTeams(), is(emptyCollectionOf(TeamScoringDetails.class)));
	}

	@Test
	public void getTeamsWithoutMatchupTest_NoOverwrite() {

		TeamScoringDetails teamScoringDetails = new TeamScoringDetails();
		teamScoringDetails.setFranchiseId("0001");

		Matchup matchup = new Matchup();
		matchup.setTeams(Arrays.asList(teamScoringDetails));

		assertThat(matchup, is(not(nullValue())));
		assertThat(matchup.getTeams(), is(not(nullValue())));
		assertThat(matchup.getTeams().size(), is(1));
		assertThat(matchup.getTeams().get(0), is(not(nullValue())));
		assertThat(matchup.getTeams().get(0).getFranchiseId(), is("0001"));
	}
}

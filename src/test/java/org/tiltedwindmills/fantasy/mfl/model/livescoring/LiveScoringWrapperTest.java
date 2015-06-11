package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

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
	public void getTeamsWithoutMatchupTest() {

		LiveScoringWrapper wrapper = new LiveScoringWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setTeamsWithoutMatchup(null);
		assertThat(wrapper.getTeamsWithoutMatchup(), is(emptyCollectionOf(TeamScoringDetails.class)));
	}
}

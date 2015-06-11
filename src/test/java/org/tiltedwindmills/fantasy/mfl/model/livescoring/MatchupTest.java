package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.livescoring.Matchup}.
 *
 * @author John Daniel
 */
public class MatchupTest {

	@Test
	public void getMatchupsTest() {

		Matchup wrapper = new Matchup();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setTeams(null);
		assertThat(wrapper.getTeams(), is(emptyCollectionOf(TeamScoringDetails.class)));
	}
}

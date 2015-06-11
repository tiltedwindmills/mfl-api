package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.livescoring.PlayerScoringWrapper}.
 *
 * @author John Daniel
 */
public class PlayerScoringWrapperTest {

	@Test
	public void getMatchupsTest() {

		PlayerScoringWrapper wrapper = new PlayerScoringWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setPlayerScores(null);
		assertThat(wrapper.getPlayerScores(), is(emptyCollectionOf(PlayerScoringDetails.class)));
	}
}

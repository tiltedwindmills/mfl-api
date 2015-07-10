package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

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

	@Test
	public void getMatchupsTest_NoOverwrite() {

		PlayerScoringDetails playerScoringDetails = new PlayerScoringDetails();
		playerScoringDetails.setPlayerId(10695);

		PlayerScoringWrapper wrapper = new PlayerScoringWrapper();
		wrapper.setPlayerScores(Arrays.asList(playerScoringDetails));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getPlayerScores(), is(not(nullValue())));
		assertThat(wrapper.getPlayerScores().size(), is(1));
		assertThat(wrapper.getPlayerScores().get(0), is(not(nullValue())));
		assertThat(wrapper.getPlayerScores().get(0).getPlayerId(), is(10695));
	}
}

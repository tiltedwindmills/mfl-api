package org.tiltedwindmills.fantasy.mfl.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.players.PlayerScoresWrapper}.  Normally we don't care about
 * the model classes, but in this instance we confirm that this one will properly initialize an empty Collection
 * rather than returning a null value when the getter is called.
 *
 * @author John Daniel
 */
public class PlayerScoresWrapperTest {


	@Test
	public void getPlayerScoresTest() {

		PlayerScoresWrapper wrapper = new PlayerScoresWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setPlayerScores(null);
		assertThat(wrapper.getPlayerScores(), is(emptyCollectionOf(PlayerScore.class)));
	}

	@Test
	public void getPlayerScoresTest_NoOverwrite() {

		PlayerScore playerScore = new PlayerScore();
		playerScore.setPlayerId(10695);

		PlayerScoresWrapper wrapper = new PlayerScoresWrapper();
		wrapper.setPlayerScores(Arrays.asList(playerScore));

		// set the value null, then immediately confirm its not returned that way.
		assertThat(wrapper.getPlayerScores(), is(not(nullValue())));
		assertThat(wrapper.getPlayerScores().size(), is(1));
		assertThat(wrapper.getPlayerScores().get(0).getPlayerId(), is(10695));
	}
}

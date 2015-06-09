package org.tiltedwindmills.fantasy.mfl.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.model.Player;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.players.PlayerWrapper}.  Normally we don't care about
 * the model classes, but in this instance we confirm that this one will properly initialize an empty Collection
 * rather than returning a null value when the getter is called.
 *
 * @author John Daniel
 */
public class PlayerWrapperTest {

	@Test
	public void getTeamsTest() {

		PlayerWrapper playerWrapper = new PlayerWrapper();

		// set the value null, then immediately confirm its not returned that way.
		playerWrapper.setPlayers(null);
		assertThat(playerWrapper.getPlayers(), is(emptyCollectionOf(Player.class)));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.players.PlayerStatusWrapper}.  Normally we don't care about
 * the model classes, but in this instance we confirm that this one will properly initialize an empty Collection
 * rather than returning a null value when the getter is called.
 *
 * @author John Daniel
 */
public class PlayerStatusWrapperTest {


	@Test
	public void getPlayerStatusesTest() {

		PlayerStatusWrapper wrapper = new PlayerStatusWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setPlayerStatuses(null);
		assertThat(wrapper.getPlayerStatuses(), is(emptyCollectionOf(PlayerAvailabilityStatus.class)));
	}

	@Test
	public void getPlayerStatusesTest_NoOverwrite() {

		PlayerAvailabilityStatus playerAvailabilityStatus = new PlayerAvailabilityStatus();
		playerAvailabilityStatus.setPlayerId(10695);

		PlayerStatusWrapper wrapper = new PlayerStatusWrapper();
		wrapper.setPlayerStatuses(Arrays.asList(playerAvailabilityStatus));

		// set the value null, then immediately confirm its not returned that way.
		assertThat(wrapper.getPlayerStatuses(), is(not(nullValue())));
		assertThat(wrapper.getPlayerStatuses().size(), is(1));
		assertThat(wrapper.getPlayerStatuses().get(0).getPlayerId(), is(10695));
	}
}

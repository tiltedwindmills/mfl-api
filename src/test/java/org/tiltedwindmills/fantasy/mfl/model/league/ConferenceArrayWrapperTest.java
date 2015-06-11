package org.tiltedwindmills.fantasy.mfl.model.league;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.league.ConferenceArrayWrapper}.
 *
 * @author John Daniel
 */
public class ConferenceArrayWrapperTest {

	@Test
	public void getConferencesTest() {

		ConferenceArrayWrapper wrapper = new ConferenceArrayWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setConferences(null);
		assertThat(wrapper.getConferences(), is(emptyCollectionOf(Conference.class)));
	}
}

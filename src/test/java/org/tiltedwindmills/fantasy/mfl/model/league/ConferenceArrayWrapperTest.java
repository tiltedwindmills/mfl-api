package org.tiltedwindmills.fantasy.mfl.model.league;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

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

	@Test
	public void getConferencesTest_NoOverwrite() {

		Conference conference = new Conference();
		conference.setName("conference 1");

		ConferenceArrayWrapper wrapper = new ConferenceArrayWrapper();
		wrapper.setConferences(Arrays.asList(conference));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getConferences(), is(not(nullValue())));
		assertThat(wrapper.getConferences().size(), is(1));
		assertThat(wrapper.getConferences().get(0), is(not(nullValue())));
		assertThat(wrapper.getConferences().get(0).getName(), is("conference 1"));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.leaguesearch;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.leaguesearch.LeagueSearchResultWrapper}.
 *
 * @author John Daniel
 */
public class LeagueSearchResultWrapperTest {

	@Test
	public void getLeaguesTest() {

		LeagueSearchResultWrapper wrapper = new LeagueSearchResultWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setLeagues(null);
		assertThat(wrapper.getLeagues(), is(emptyCollectionOf(LeagueSearchResult.class)));
	}

	@Test
	public void getLeaguesTest_NoOverwrite() {

		LeagueSearchResult leagueSearchResult = new LeagueSearchResult();
		leagueSearchResult.setName("result 1");

		LeagueSearchResultWrapper wrapper = new LeagueSearchResultWrapper();
		wrapper.setLeagues(Arrays.asList(leagueSearchResult));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getLeagues(), is(not(nullValue())));
		assertThat(wrapper.getLeagues().size(), is(1));
		assertThat(wrapper.getLeagues().get(0), is(not(nullValue())));
		assertThat(wrapper.getLeagues().get(0).getName(), is("result 1"));
	}
}

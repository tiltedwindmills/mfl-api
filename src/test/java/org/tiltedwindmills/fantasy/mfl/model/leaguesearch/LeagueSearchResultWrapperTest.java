package org.tiltedwindmills.fantasy.mfl.model.leaguesearch;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

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
}

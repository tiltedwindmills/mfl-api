package org.tiltedwindmills.fantasy.mfl.model.nflschedule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLMatchup}.  Normally we don't care about
 * the model classes, but in this instance we confirm that this one will properly initialize an empty Collection
 * rather than returning a null value when the getter is called.
 *
 * @author John Daniel
 */
public class NFLMatchupTest {

	@Test
	public void getTeamsTest() {

		NFLMatchup nflMatchup = new NFLMatchup();

		// set the value null, then immediately confirm its not returned that way.
		nflMatchup.setTeams(null);
		assertThat(nflMatchup.getTeams(), is(emptyCollectionOf(NFLTeam.class)));
	}
}

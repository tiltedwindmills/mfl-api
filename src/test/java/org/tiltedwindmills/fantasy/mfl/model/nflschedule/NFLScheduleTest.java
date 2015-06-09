package org.tiltedwindmills.fantasy.mfl.model.nflschedule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule}.  Normally we don't care about
 * the model classes, but in this instance we confirm that this one will properly initialize an empty Collection
 * rather than returning a null value when the getter is called.
 *
 * @author John Daniel
 */
public class NFLScheduleTest {

	@Test
	public void getTeamsTest() {

		NFLSchedule nflSchedule = new NFLSchedule();

		// set the value null, then immediately confirm its not returned that way.
		nflSchedule.setMatchups(null);
		assertThat(nflSchedule.getMatchups(), is(emptyCollectionOf(NFLMatchup.class)));
	}


}

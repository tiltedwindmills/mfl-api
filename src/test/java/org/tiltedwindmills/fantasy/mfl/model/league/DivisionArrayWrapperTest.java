package org.tiltedwindmills.fantasy.mfl.model.league;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.league.DivisionArrayWrapper}.
 *
 * @author John Daniel
 */
public class DivisionArrayWrapperTest {

	@Test
	public void getDivisionsTest() {

		DivisionArrayWrapper wrapper = new DivisionArrayWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setDivisions(null);
		assertThat(wrapper.getDivisions(), is(emptyCollectionOf(Division.class)));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.league;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

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

	@Test
	public void getDivisionsTestTest_NoOverwrite() {

		Division division = new Division();
		division.setName("division 1");

		DivisionArrayWrapper wrapper = new DivisionArrayWrapper();
		wrapper.setDivisions(Arrays.asList(division));

		assertThat(wrapper, is(not(nullValue())));
		assertThat(wrapper.getDivisions(), is(not(nullValue())));
		assertThat(wrapper.getDivisions().size(), is(1));
		assertThat(wrapper.getDivisions().get(0), is(not(nullValue())));
		assertThat(wrapper.getDivisions().get(0).getName(), is("division 1"));
	}
}

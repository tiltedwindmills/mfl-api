package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.FranchiseArrayWrapper}.
 *
 * @author John Daniel
 */
public class FranchiseArrayWrapperTest {

	@Test
	public void getFranchisesTest() {

		FranchiseArrayWrapper wrapper = new FranchiseArrayWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setFranchises(null);
		assertThat(wrapper.getFranchises(), is(emptyCollectionOf(Franchise.class)));
	}

	@Test
	public void getFranchisesTest_NoOverwrite() {

		Franchise franchise = new Franchise();
		franchise.setName("foo");

		FranchiseArrayWrapper wrapper = new FranchiseArrayWrapper();
		wrapper.setFranchises(Arrays.asList(franchise));

		// set the value null, then immediately confirm its not returned that way.
		assertThat(wrapper.getFranchises(), is(not(nullValue())));
		assertThat(wrapper.getFranchises().size(), is(1));
		assertThat(wrapper.getFranchises().get(0).getName(), is("foo"));
	}
}

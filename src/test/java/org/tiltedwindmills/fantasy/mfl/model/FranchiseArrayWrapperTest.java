package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

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
}

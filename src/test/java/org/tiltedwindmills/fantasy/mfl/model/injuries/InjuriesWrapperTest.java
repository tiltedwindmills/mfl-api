package org.tiltedwindmills.fantasy.mfl.model.injuries;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.injuries.InjuriesWrapper}.
 *
 * @author John Daniel
 */
public class InjuriesWrapperTest {

	@Test
	public void getInjuriesTest() {

		InjuriesWrapper wrapper = new InjuriesWrapper();

		// set the value null, then immediately confirm its not returned that way.
		wrapper.setInjuries(null);
		assertThat(wrapper.getInjuries(), is(emptyCollectionOf(Injury.class)));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.injuries;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

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

	@Test
	public void getPicksTest_NoOverwrite() {

		Injury injury = new Injury();
		injury.setPlayerId(10695);

		InjuriesWrapper injuryWrapper = new InjuriesWrapper();
		injuryWrapper.setInjuries(Arrays.asList(injury));

		assertThat(injuryWrapper, is(not(nullValue())));
		assertThat(injuryWrapper.getInjuries(), is(not(nullValue())));
		assertThat(injuryWrapper.getInjuries().size(), is(1));
		assertThat(injuryWrapper.getInjuries().get(0), is(not(nullValue())));
		assertThat(injuryWrapper.getInjuries().get(0).getPlayerId(), is(10695));
	}
}

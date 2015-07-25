package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.H2HType}
 *
 * @author John Daniel
 */
public class H2HTypeTest {

	@Test
	public void getStandardFromValueTest() {
		assertThat(H2HType.fromValue("YES"), is(H2HType.STANDARD));
	}

	@Test
	public void getStandardFromValueTestIgnoreCase() {
		assertThat(H2HType.fromValue("yEs"), is(H2HType.STANDARD));
	}

	@Test
	public void getDoubleheadersFromValueTest() {
		assertThat(H2HType.fromValue("Doubleheaders"), is(H2HType.DOUBLEHEADERS));
	}

	@Test
	public void getDoubleheadersFromValueTestIgnoreCase() {
		assertThat(H2HType.fromValue("dOuBlEhEaDeRs"), is(H2HType.DOUBLEHEADERS));
	}

	@Test
	public void getAllPlayFromValueTest() {
		assertThat(H2HType.fromValue("ALL"), is(H2HType.ALL_PLAY));
	}

	@Test
	public void getAllPlayFromValueTestIgnoreCases() {
		assertThat(H2HType.fromValue("aLl"), is(H2HType.ALL_PLAY));
	}

	@Test
	public void getTotalPointsFromValueTest() {
		assertThat(H2HType.fromValue(""), is(H2HType.TOTAL_POINTS));
	}

	@Test(expected=IllegalArgumentException.class)
	public void getFromValueTestNull() {
		H2HType.fromValue(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void getFromValueTestUnknown() {
		H2HType.fromValue("some value");
	}
}

package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.PlayerStatus}
 *
 * @author John Daniel
 */
public class PlayerStatusTest {

	@Test
	public void getActiveFromValueTest() {
		assertThat(PlayerStatus.fromValue("ROSTER"), is(PlayerStatus.Active));
	}

	@Test
	public void getActiveFromValueTestIgnoreCase() {
		assertThat(PlayerStatus.fromValue("rOsTeR"), is(PlayerStatus.Active));
	}
}

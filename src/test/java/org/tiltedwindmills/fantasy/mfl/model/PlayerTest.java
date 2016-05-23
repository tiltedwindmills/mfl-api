package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Objects;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.Player}.  Only does trivial validation of the standard
 * object methods at this time.
 *
 * @author John Daniel
 */
public class PlayerTest {

	@Test
	public void parameterizedConstructorTest() {

		Player player = new Player("a name", "9", "NOS", Position.QUARTERBACK);

		assertThat(player.getName(), is("a name"));
		assertThat(player.getId(), is("9"));
		assertThat(player.getTeam(), is("NOS"));
		assertThat(player.getPosition(), is(Position.QUARTERBACK));
	}

	@Test
	public void getAgeTestNegative() {

		Player player = new Player();
		player.setBirthday(-1L);

		assertThat(player.getAge(), is(0));
	}

	@Test
	public void hashCodeTest() {

		Player player = new Player("a name", "9", "NOS", Position.QUARTERBACK);
		assertThat(player.hashCode(), is(Objects.hashCode(9)));
	}

	@Test
	public void equalsTest() {

		Player player1 = new Player("a name", "9", "NOS", Position.QUARTERBACK);
		Player player2 = new Player("a name", "9", "NOS", Position.QUARTERBACK);

		assert(player1.equals(player2));
	}

	@Test
	public void toStringTest() {

		Player player = new Player("a name", "9", "NOS", Position.QUARTERBACK);
		assertThat(player.toString(), is("QB a name, NOS"));
	}

	@Test
	public void toStringNoPositionTest() {

		Player player = new Player();
		player.setName("a name");
		player.setId("9");
		player.setTeam("NOS");

		assertThat(player.getPosition(), is(nullValue()));
		assertThat(player.toString(), is("a name, NOS"));
	}
}

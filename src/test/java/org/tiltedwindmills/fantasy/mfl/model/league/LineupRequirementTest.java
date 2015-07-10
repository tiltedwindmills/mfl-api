package org.tiltedwindmills.fantasy.mfl.model.league;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.model.Position;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.league.LineupRequirement}.
 *
 * @author John Daniel
 */
public class LineupRequirementTest {

	@Test
	public void getPositionRequirementsTest() {

		LineupRequirement lineupRequirement = new LineupRequirement();

		// set the value null, then immediately confirm its not returned that way.
		lineupRequirement.setPositionRequirements(null);
		assertThat(lineupRequirement.getPositionRequirements(), is(emptyCollectionOf(PositionRequirement.class)));
	}

	@Test
	public void getPositionRequirementsTest_NoOverwrite() {

		PositionRequirement positionRequirement = new PositionRequirement();
		positionRequirement.setPosition(Position.QUARTERBACK);

		LineupRequirement lineupRequirement = new LineupRequirement();
		lineupRequirement.setPositionRequirements(Arrays.asList(positionRequirement));

		assertThat(lineupRequirement, is(not(nullValue())));
		assertThat(lineupRequirement.getPositionRequirements(), is(not(nullValue())));
		assertThat(lineupRequirement.getPositionRequirements().size(), is(1));
		assertThat(lineupRequirement.getPositionRequirements().get(0), is(not(nullValue())));
		assertThat(lineupRequirement.getPositionRequirements().get(0).getPosition(), is(Position.QUARTERBACK));
	}
}

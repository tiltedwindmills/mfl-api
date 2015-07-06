package org.tiltedwindmills.fantasy.mfl.model.injuries;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.injuries.Injury}.  Testing is primarily done to
 * account for the code written to handle the trailing endline placed on MFL's injury "details" element.
 *
 * @author John Daniel
 */
public class InjuryTest {

	@Test
	public void setDetailsTest() {

		Injury injury = new Injury();
		injury.setDetails("foo\n");
		assertThat(injury.getDetails(), is("foo"));
	}

	@Test
	public void setDetailsTest_Null() {

		Injury injury = new Injury();
		injury.setDetails(null);
		assertThat(injury.getDetails(), is(nullValue()));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.draft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.draft.Draft}.
 *
 * @author John Daniel
 */
public class DraftTest {

	@Test
	public void getPicksTest() {

		Draft draft = new Draft();

		// set the value null, then immediately confirm its not returned that way.
		draft.setPicks(null);
		assertThat(draft.getPicks(), is(emptyCollectionOf(DraftPick.class)));
	}
}

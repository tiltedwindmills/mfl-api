package org.tiltedwindmills.fantasy.mfl.model.draft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

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

	@Test
	public void getPicksTest_NoOverwrite() {

		DraftPick pick = new DraftPick();
		pick.setPlayerId("10695");

		Draft draft = new Draft();
		draft.setPicks(Arrays.asList(pick));

		assertThat(draft, is(not(nullValue())));
		assertThat(draft.getPicks(), is(not(nullValue())));
		assertThat(draft.getPicks().size(), is(1));
		assertThat(draft.getPicks().get(0), is(not(nullValue())));
		assertThat(draft.getPicks().get(0).getPlayerId(), is("10695"));
	}
}

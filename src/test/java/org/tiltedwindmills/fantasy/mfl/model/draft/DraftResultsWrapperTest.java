package org.tiltedwindmills.fantasy.mfl.model.draft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.draft.DraftResultsWrapper}.
 *
 * @author John Daniel
 */
public class DraftResultsWrapperTest {

	@Test
	public void getDraftTest() {

		DraftResultsWrapper draftResultsWrapper = new DraftResultsWrapper();

		// set the value null, then immediately confirm its not returned that way.
		draftResultsWrapper.setDrafts(null);
		assertThat(draftResultsWrapper.getDrafts(), is(emptyCollectionOf(Draft.class)));
	}

	@Test
	public void getDraftTest_NoOverwrite() {

		DraftPick pick = new DraftPick();
		pick.setPlayerId("10695");

		Draft draft = new Draft();
		draft.setPicks(Arrays.asList(pick));

		DraftResultsWrapper wrapper = new DraftResultsWrapper();
		wrapper.setDrafts(Arrays.asList(draft));

		assertThat(wrapper.getDrafts(), is(not(nullValue())));
		assertThat(wrapper.getDrafts().size(), is(1));
		assertThat(wrapper.getDrafts().get(0).getPicks(), is(not(nullValue())));
		assertThat(wrapper.getDrafts().get(0).getPicks().size(), is(1));
		assertThat(wrapper.getDrafts().get(0).getPicks().get(0), is(not(nullValue())));
		assertThat(wrapper.getDrafts().get(0).getPicks().get(0).getPlayerId(), is("10695"));
	}
}

package org.tiltedwindmills.fantasy.mfl.model.draft;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

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
}

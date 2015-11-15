package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Empty collection test for {@code org.tiltedwindmills.fantasy.mfl.model.weeklyresults.MatchupResults}.
 *
 * @author John Daniel
 */
public class MatchupResultsTest {

    @Test
    public void getTeamsTest() {

        MatchupResults matchupResults = new MatchupResults();

        // set the value null, then immediately confirm its not returned that way.
        matchupResults.setTeams(null);
        assertThat(matchupResults.getTeams(), is(emptyCollectionOf(TeamResultDetails.class)));
    }
}

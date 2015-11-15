package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Empty collection test for {@code org.tiltedwindmills.fantasy.mfl.model.weeklyresults.WeeklyResultsWrapper}.
 *
 * @author John Daniel
 */
public class WeeklyResultsWrapperTest {

    @Test
    public void getMatchupResultsTest() {

        WeeklyResultsWrapper weeklyResultsWrapper = new WeeklyResultsWrapper();

        // set the value null, then immediately confirm its not returned that way.
        weeklyResultsWrapper.setMatchupResults(null);
        assertThat(weeklyResultsWrapper.getMatchupResults(), is(emptyCollectionOf(MatchupResults.class)));
    }

    @Test
    public void getTeamResultDetailsTest() {

        WeeklyResultsWrapper weeklyResultsWrapper = new WeeklyResultsWrapper();

        // set the value null, then immediately confirm its not returned that way.
        weeklyResultsWrapper.setTeamsWithoutMatchup(null);
        assertThat(weeklyResultsWrapper.getTeamsWithoutMatchup(), is(emptyCollectionOf(TeamResultDetails.class)));
    }
}

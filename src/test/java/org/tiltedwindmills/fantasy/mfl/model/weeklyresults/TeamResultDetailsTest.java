package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;

import org.junit.Test;

/**
 * Empty collection test for {@code org.tiltedwindmills.fantasy.mfl.model.weeklyresults.TeamResultDetails}. Each test
 * simply sets the value null, then immediately confirm its not returned that way.
 *
 * @author John Daniel
 */
public class TeamResultDetailsTest {

    @Test
    public void getOptimalTest() {

        TeamResultDetails teamResultDetails = new TeamResultDetails();
        teamResultDetails.setOptimal(null);
        assertThat(teamResultDetails.getOptimal(), is(emptyCollectionOf(Integer.class)));
    }

    @Test
    public void getStartersTest() {

        TeamResultDetails teamResultDetails = new TeamResultDetails();
        teamResultDetails.setStarters(null);
        assertThat(teamResultDetails.getStarters(), is(emptyCollectionOf(Integer.class)));
    }

    @Test
    public void getNonStartersTest() {

        TeamResultDetails teamResultDetails = new TeamResultDetails();
        teamResultDetails.setNonStarters(null);
        assertThat(teamResultDetails.getNonStarters(), is(emptyCollectionOf(Integer.class)));
    }

    @Test
    public void getPlayerResultsTest() {

        TeamResultDetails teamResultDetails = new TeamResultDetails();
        teamResultDetails.setPlayerResults(null);
        assertThat(teamResultDetails.getPlayerResults(), is(emptyCollectionOf(PlayerResultDetails.class)));
    }
}

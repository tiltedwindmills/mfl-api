package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import mockit.Capturing;
import mockit.NonStrictExpectations;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.JsonDataConverter;
import org.tiltedwindmills.fantasy.mfl.model.weeklyresults.TeamResultDetails;
import org.tiltedwindmills.fantasy.mfl.model.weeklyresults.WeeklyResultsWrapper;
import org.tiltedwindmills.fantasy.mfl.services.LeagueService;


public class JsonLeagueServiceImplTest {

    // constants
    private static final int RANDOM_LEAGUE_ID = 11111;
    private static final int RANDOM_WEEK = 1;
    private static final String RANDOM_SERVER_ID = "1";

    // mock any implementers of the Retrofit interface
    @Capturing private MflLeagueExport mflLeagueExport;


    /*----------------------------------------------- getWeeklyResults ---------------------------------------------*/

    @Test
    public void getWeeklyResultsTest() {

        new NonStrictExpectations() {{
            mflLeagueExport.getWeeklyResults(anyInt, anyInt, anyInt);
                        returns(JsonDataConverter.weeklyResults("completed-week"));
        }};

        LeagueService leagueService = new JsonLeagueServiceImpl();
        WeeklyResultsWrapper weeklyResultsWrapper = leagueService.getWeeklyResults(RANDOM_LEAGUE_ID, RANDOM_WEEK, RANDOM_SERVER_ID, 2015);

        assertThat(weeklyResultsWrapper, is(not(nullValue())));
        assertThat(weeklyResultsWrapper.getMatchupResults(), hasSize(5));
        assertThat(weeklyResultsWrapper.getMatchupResults().get(0).getTeams(), hasSize(2));


        TeamResultDetails teamResultDetails = weeklyResultsWrapper.getMatchupResults().get(0).getTeams().get(0);

        assertThat(teamResultDetails.getFranchiseId(), is("0007"));
        assertThat(teamResultDetails.getScore(), is(116.7));
        assertThat(teamResultDetails.getSpread(), is(-7.3));

        // check both sides of the win/loss
        assertThat(teamResultDetails.isWin(), is(true));
        assertThat(weeklyResultsWrapper.getMatchupResults().get(0).getTeams().get(1).isWin(), is(false));

        // check both sides of the home/away
        assertThat(teamResultDetails.isHome(), is(false));
        assertThat(weeklyResultsWrapper.getMatchupResults().get(0).getTeams().get(1).isHome(), is(true));

        assertThat(teamResultDetails.getPlayerResults().get(0).getShouldStart(), is(true));
        assertThat(teamResultDetails.getPlayerResults().get(0).getStatus(), is("starter"));
        assertThat(teamResultDetails.getPlayerResults().get(0).getScore(), is(18.5));
        assertThat(teamResultDetails.getPlayerResults().get(0).getPlayerId(), is(4925));

        assertThat(teamResultDetails.getOptimal(), hasSize(17));
        assertThat(teamResultDetails.getOptimal(), hasItems(10077, 10292, 11175));

        assertThat(teamResultDetails.getStarters(), hasSize(17));
        assertThat(teamResultDetails.getStarters(), hasItems(4925, 8687, 3294));

        assertThat(teamResultDetails.getNonStarters(), hasSize(18));
        assertThat(teamResultDetails.getNonStarters(), hasItems(11640, 11353, 9078));
    }
}

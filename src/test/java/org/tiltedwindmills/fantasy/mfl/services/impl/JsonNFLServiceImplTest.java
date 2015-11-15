package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import mockit.Capturing;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.JsonDataConverter;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLMatchup;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLTeam;
import org.tiltedwindmills.fantasy.mfl.services.NFLService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.services.impl.JsonNFLServiceImpl}.
 *
 * @author John Daniel
 */
public class JsonNFLServiceImplTest {

    @Capturing private MflNflExport mflNflExport;

    @Test
    public void getNFLScheduleTest() {

        new NonStrictExpectations() {{
            mflNflExport.getNFLSchedule(anyInt, anyInt); returns(JsonDataConverter.nflSchedule("not-started-week"));
        }};

        NFLService nflService = new JsonNFLServiceImpl();
        NFLSchedule nflSchedule = nflService.getNFLSchedule(1, 2015);

        assertThat(nflSchedule, is(not(nullValue())));
        assertThat(nflSchedule.getWeek(), is(1));
        assertThat(nflSchedule.getMatchups(), is(not(nullValue())));
        assertThat(nflSchedule.getMatchups().size(), is(16));

        NFLMatchup matchup = nflSchedule.getMatchups().get(0);
        assertThat(matchup, is(not(nullValue())));
        assertThat(matchup.getGameSecondsRemaining(), is(3600));

        DateTime kickoff = new DateTime(matchup.getKickoff() * 1000);
        assertThat(kickoff.getMonthOfYear(), is(DateTimeConstants.SEPTEMBER));
        assertThat(kickoff.getDayOfMonth(), is(10));
        assertThat(kickoff.getYear(), is(2015));

        assertThat(matchup.getTeams(), not(emptyCollectionOf(NFLTeam.class)));
        assertThat(matchup.getTeams().get(0).getTeamId(), is("PIT"));
        assertThat(matchup.getTeams().get(1).getTeamId(), is("NEP"));
    }

    @Test
    public void getAllPlayersTest_BadWeek() {

        try {
            NFLService nflService = new JsonNFLServiceImpl();
            nflService.getNFLSchedule(0, 2015);

            fail("should have thrown exception");

        } catch (MFLServiceException e) {
            // expected
        }

        new Verifications() {{

            // Verifies that zero calls to the service API occurred
            mflNflExport.getNFLSchedule(anyInt, anyInt); times = 0;
        }};
    }

    @Test
    public void getAllPlayersTest_BadYear() {

        try {
            NFLService nflService = new JsonNFLServiceImpl();
            nflService.getNFLSchedule(2, 1979);

            fail("should have thrown exception");

        } catch (MFLServiceException e) {
            // expected
        }

        new Verifications() {{

            // Verifies that zero calls to the service API occurred
            mflNflExport.getNFLSchedule(anyInt, anyInt); times = 0;
        }};
    }

    @Test
    public void getAllPlayersTest_BadWeekAndYear() {

        try {
            NFLService nflService = new JsonNFLServiceImpl();
            nflService.getNFLSchedule(0, 1979);

            fail("should have thrown exception");

        } catch (MFLServiceException e) {
            // expected
        }

        new Verifications() {{

            // Verifies that zero calls to the service API occurred
            mflNflExport.getNFLSchedule(anyInt, anyInt); times = 0;
        }};
    }

    @Test
    public void getAllPlayersTest_HttpError() {

        new NonStrictExpectations() {{

            Response response = new Response("some url", 500, "some reason", new ArrayList<Header>(), null);
            RetrofitError error = RetrofitError.httpError("someUrl", response, null, null);
            mflNflExport.getNFLSchedule(anyInt, anyInt); result = error;
        }};

        try {
            NFLService nflService = new JsonNFLServiceImpl();
            nflService.getNFLSchedule(1, 2015);
            fail("should have thrown exception.");

        } catch (MFLServiceException e) {
            // expected behavior.  Confirm root cause is propagated.
            assertThat(e.getCause(), instanceOf(RetrofitError.class));
        }
    }

    @Test(expected = MFLServiceException.class)
    public void getAllPlayersTest_NullResponse() {

        new NonStrictExpectations() {{
            mflNflExport.getNFLSchedule(anyInt, anyInt); returns(null);
        }};

        NFLService nflService = new JsonNFLServiceImpl();
        nflService.getNFLSchedule(1, 2015);
    }
}

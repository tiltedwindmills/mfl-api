package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class WeeklyResultsWrapper.
 */
public class WeeklyResultsWrapper extends AbstractObject {

    private static final long serialVersionUID = -4350615998109208617L;

    /** The week. */
    private int week;

    /** The matchups. */
    @JsonProperty("matchup")
    private List<MatchupResults> matchupResults;

    /** The franchises that aren't in matchups this week.  Playoffs, etc. */
    @JsonProperty("franchise")
    private List<TeamResultDetails> teamsWithoutMatchup;  // TODO : need export to test this case


    /**
     * Gets the matchups.
     *
     * @return the matchups
     */
    public final List<MatchupResults> getMatchupResults() {

        if (matchupResults == null) {
            matchupResults = new ArrayList<MatchupResults>();
        }

        return matchupResults;
    }

    /**
     * Sets the matchups.
     *
     * @param matchupResults the new matchups
     */
    public final void setMatchupResults(final List<MatchupResults> matchupResults) {
        this.matchupResults = matchupResults;
    }

    /**
     * Gets the week.
     *
     * @return the week
     */
    public final int getWeek() {
        return week;
    }

    /**
     * Sets the week.
     *
     * @param week the new week
     */
    public final void setWeek(final int week) {
        this.week = week;
    }

    /**
     * Gets the teams without matchup.
     *
     * @return the teams without matchup
     */
    public final List<TeamResultDetails> getTeamsWithoutMatchup() {

        if (teamsWithoutMatchup == null) {
            teamsWithoutMatchup = new ArrayList<TeamResultDetails>();
        }

        return teamsWithoutMatchup;
    }

    /**
     * Sets the teams without matchup.
     *
     * @param teamsWithoutMatchup the new teams without matchup
     */
    public final void setTeamsWithoutMatchup(final List<TeamResultDetails> teamsWithoutMatchup) {
        this.teamsWithoutMatchup = teamsWithoutMatchup;
    }
}

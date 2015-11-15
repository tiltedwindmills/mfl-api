package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class MatchupResults.
 */
public class MatchupResults extends AbstractObject {

    private static final long serialVersionUID = 5187379239217292676L;

    /** The teams. */
    @JsonProperty("franchise")
    private List<TeamResultDetails> teams;

    /**
     * Gets the teams.
     *
     * @return the teams
     */
    public final List<TeamResultDetails> getTeams() {

        if (teams == null) {
            teams = new ArrayList<TeamResultDetails>();
        }

        return teams;
    }

    /**
     * Sets the teams.
     *
     * @param teams the new teams
     */
    public final void setTeams(final List<TeamResultDetails> teams) {
        this.teams = teams;
    }
}

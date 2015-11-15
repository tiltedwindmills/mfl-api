package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates the response from a request to the "weeklyresults" MFL export.
 */
@JsonIgnoreProperties({ "encoding", "version" })
public class WeeklyResultsResponse extends AbstractObject {

    private static final long serialVersionUID = -7751845103263203880L;

    /** The weeky results`. */
    @JsonProperty("weeklyResults")
    private WeeklyResultsWrapper weeklyResults;

    /**
     * Gets the weekly results.
     *
     * @return the weekly results
     */
    public final WeeklyResultsWrapper getWeeklyResults() {

        return weeklyResults;
    }

    /**
     * Sets the weekly results.
     *
     * @param weeklyResults the new weekly results
     */
    public final void setWeeklyResults(final WeeklyResultsWrapper weeklyResults) {

        this.weeklyResults = weeklyResults;
    }
}

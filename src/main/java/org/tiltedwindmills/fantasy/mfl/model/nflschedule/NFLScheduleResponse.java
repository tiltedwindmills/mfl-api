package org.tiltedwindmills.fantasy.mfl.model.nflSchedule;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates the response from a request to the "nlfSchedule" MFL export.
 */
@JsonIgnoreProperties({ "encoding", "version" })
public class NFLScheduleResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7885401574712739281L;

	/** The nfl schedule. */
	@JsonProperty("nflSchedule")
	private NFLSchedule nflSchedule;

	/**
	 * Gets the nfl schedule.
	 *
	 * @return the nfl schedule
	 */
	public final NFLSchedule getNflSchedule() {
		return nflSchedule;
	}

	/**
	 * Sets the nfl schedule.
	 *
	 * @param nflSchedule the new nfl schedule
	 */
	public final void setNflSchedule(final NFLSchedule nflSchedule) {
		this.nflSchedule = nflSchedule;
	}
}

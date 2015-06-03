package org.tiltedwindmills.fantasy.mfl.model.livescoring;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates the response from a request to the "livescoring" MFL export.
 */
@JsonIgnoreProperties({ "encoding", "version" })
public class LiveScoringResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2599638060239724321L;

	/** The live scoring. */
	@JsonProperty("liveScoring")
	private LiveScoringWrapper liveScoring;

	/**
	 * Gets the live scoring.
	 *
	 * @return the live scoring
	 */
	public final LiveScoringWrapper getLiveScoring() {

		return liveScoring;
	}

	/**
	 * Sets the live scoring.
	 *
	 * @param liveScoring the new live scoring
	 */
	public final void setLiveScoring(final LiveScoringWrapper liveScoring) {

		this.liveScoring = liveScoring;
	}
}

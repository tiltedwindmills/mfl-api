package org.tiltedwindmills.fantasy.mfl.model.standings;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class StandingsResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2695991479094988101L;

	/** The wrapper. */
	@JsonProperty("standings")
	private StandingsWrapper wrapper;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final StandingsWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final StandingsWrapper wrapper) {
		this.wrapper = wrapper;
	}
}

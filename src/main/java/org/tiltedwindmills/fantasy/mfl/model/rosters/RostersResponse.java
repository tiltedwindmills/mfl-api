package org.tiltedwindmills.fantasy.mfl.model.rosters;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class RostersResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RostersResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1432835978720263548L;

	/** The wrapper. */
	@JsonProperty("rosters")
	private RostersWrapper wrapper;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final RostersWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final RostersWrapper wrapper) {
		this.wrapper = wrapper;
	}
}

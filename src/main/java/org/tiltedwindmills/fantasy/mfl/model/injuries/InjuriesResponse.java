package org.tiltedwindmills.fantasy.mfl.model.injuries;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates the response from a request to the "injuries" MFL export.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InjuriesResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6784817084571452996L;

	/** The injuries wrapper. */
	@JsonProperty("injuries")
	private InjuriesWrapper wrapper;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final InjuriesWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final InjuriesWrapper wrapper) {
		this.wrapper = wrapper;
	}
}

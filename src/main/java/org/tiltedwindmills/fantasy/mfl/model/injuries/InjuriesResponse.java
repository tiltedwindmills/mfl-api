package org.tiltedwindmills.fantasy.mfl.model.injuries;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Encapsulates the response from a request to the "injuries" MFL export.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InjuriesResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5746719180237454152L;

	/** The leagues. */
	private InjuriesWrapper injuries;

	/**
	 * Gets the injuries.
	 *
	 * @return the injuries
	 */
	public final InjuriesWrapper getInjuries() {
		return injuries;
	}

	/**
	 * Sets the injuries.
	 *
	 * @param injuries the new injuries
	 */
	public final void setInjuries(final InjuriesWrapper injuries) {
		this.injuries = injuries;
	}
}

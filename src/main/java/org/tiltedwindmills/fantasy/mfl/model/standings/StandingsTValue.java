package org.tiltedwindmills.fantasy.mfl.model.standings;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class StandingsTValue.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsTValue extends AbstractObject {

	/** serial version UID. */
	private static final long serialVersionUID = -1960246706872361483L;

	/** The value. */
	@JsonProperty("$t")
	private String value;

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public final void setValue(final String value) {
		this.value = value;
	}
}

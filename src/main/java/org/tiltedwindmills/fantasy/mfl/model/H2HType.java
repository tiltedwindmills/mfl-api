package org.tiltedwindmills.fantasy.mfl.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeration representing the type of scoring a league uses.
 */
public enum H2HType {

	// TODO : these values seem all fubar'd.  Is this really what MFL is returning????

	/** one head-to-head matchup per week. */
	STANDARD("YES"),

	/** doubleheaders each week. */
	DOUBLEHEADERS("Doubleheaders"),

	/** all teams play all other teams each week (this is often called an "all-play" league). */
	ALL_PLAY("ALL"),

	/** total points only league. */
	TOTAL_POINTS("");

	private String value;

	/**
	 * Instantiates a new h2h from the provided value.
	 *
	 * @param value the value
	 */
	private H2HType(final String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Creates an instance of this enumeration from an input string.  This input corresponds to the value of the
	 * "h2h" attribute on an MFL "league" export.
	 *
	 * @param value the value
	 * @return the h2h type
	 */
	@JsonCreator
	public static H2HType fromValue(final String value) {

		// TODO : this throws exception when value doesn't match.  Other enums do not.  Standardize?
		// TODO : if exception is decision above, should it throw MFLServiceException?

		// iterate the list to make sure we're getting the right entry.
		if (value != null) {
			for(H2HType type : H2HType.values()) {
				if (value.equalsIgnoreCase(type.getValue())) {
					return type;
				}
			}

			throw new IllegalArgumentException(value + " is an invalid value.");
		}

		throw new IllegalArgumentException("A value was not provided.");
	}
}

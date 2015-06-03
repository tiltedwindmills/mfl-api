package org.tiltedwindmills.fantasy.mfl.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeration representing the type of scoring a league uses.
 */
public enum H2HType {

	/** one head-to-head matchup per week. */
    STANDARD("YES"),

    /** doubleheaders each week. */
    DOUBLEHEADERS("Doubleheaders"),

    /** all teams play all other teams each week (this is often called an "all-play" league). */
    ALL_PLAY("ALL"),

    /** total points only league. */
    TOTAL_POINTS("");

    private String type;

    /**
     * Instantiates a new h2 h type.
     *
     * @param type the type
     */
    private H2HType(final String type) {
        this.type = type;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Creates an instance of this enumeration from an input string.  This input corresponds to the value of the
     * "h2h" attribute on an MFL "league" export.
     *
     * @param status the status
     * @return the h2 h type
     */
    @JsonCreator
    public static H2HType fromValue(final String status) {

    	// iterate the list to make sure we're getting the right entry.
        if (status != null) {
            for(H2HType type : H2HType.values()) {
                if (status.equalsIgnoreCase(type.getType())) {
                    return type;
                }
            }

            throw new IllegalArgumentException(status + " is an invalid value.");
        }

        throw new IllegalArgumentException("A value was not provided.");
    }
}

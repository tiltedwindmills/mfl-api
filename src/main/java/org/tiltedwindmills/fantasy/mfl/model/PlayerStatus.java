package org.tiltedwindmills.fantasy.mfl.model;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeration representing the type of scoring a league uses.
 */
public enum PlayerStatus {

    /** Active players. */
	Active("ROSTER"),

    /** IR'd players. */
	IR("INJURED_RESERVE"),

    /** Taxi squad players. */
	Taxi("TAXI_SQUAD"),

	Unknown("??");

    /** The type. */
    private String type;

    /**
     * Instantiates a new player status type.
     *
     * @param type the type
     */
    private PlayerStatus(final String type) {
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
     * Gets the logger.
     *
     * @return the logger
     */
    private static Logger getLogger() {
      return LoggerFactory.getLogger(PlayerStatus.class);
    }

    /**
     * Creates an instance of this enumeration from an input string.  This input corresponds to the value of the
     * "status" attribute on MFL "rosters" export.
     *
     * @param pos the pos
     * @return the position
     */
    @JsonCreator
    public static PlayerStatus fromValue(final String pos) {

    	// iterate the list to make sure we're getting the right entry.
        if (StringUtils.isNotBlank(pos)) {
            for(PlayerStatus type : PlayerStatus.values()) {
                if (pos.equalsIgnoreCase(type.getType())) {
                    return type;
                }
            }

            getLogger().warn("{} is an invalid value.", pos);
        }
        else {
        	getLogger().warn("A value was not provided.");
        }

        return Unknown;
    }
}

package org.tiltedwindmills.fantasy.mfl.model;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeration representing the type of scoring a league uses.
 */
public enum Position {

    /** The head coach. */
    HEAD_COACH("Coach"),

    /** The quarterback. */
    QUARTERBACK("QB"),

    /** The team quarterback. */
    TEAM_QUARTERBACK("TMQB"),

    /** The running back. */
    RUNNING_BACK("RB"),

    /** The team running back. */
    TEAM_RUNNINGBACK("TMRB"),

    /** The full back. */
    FULL_BACK("FB"),

    /** The wide receiver. */
    WIDE_RECEIVER("WR"),

    /** The team wide receiver. */
    TEAM_WIDE_RECEIVER("TMWR"),

    /** The tight end. */
    TIGHT_END("TE"),

    /** The team tight end. */
    TEAM_TIGHT_END("TMTE"),

    /** The combined receiver. */
    COMBINED_RECEIVER("WR+TE"),

    /** The flex. */
    FLEX("RB+WR+TE"),

    /** The kick returner. */
    KICK_RETURNER("KR"),

    /** The kicker. */
    KICKER("PK"),

    /** The team kicker. */
    TEAM_KICKER("TMPK"),

    /** The punter. */
    PUNTER("PN"),

    /** The team punter. */
    TEAM_PUNTER("TMPN"),

    /** The defensive lineman. */
    DEFENSIVE_LINEMAN("DT+DE"),

    /** The defensive tackle. */
    DEFENSIVE_TACKLE("DT"),

    /** The defensive end. */
    DEFENSIVE_END("DE"),

    /** The team defensive line. */
    TEAM_DEFENSIVE_LINE("TMDL"),

    /** The linebacker. */
    LINEBACKER("LB"),

    /** The team linebacker. */
    TEAM_LINEBACKER("TMLB"),

    /** The defensive back. */
    DEFENSIVE_BACK("CB+S"),

    /** The cornerback. */
    CORNERBACK("CB"),

    /** The safety. */
    SAFETY("S"),

    /** The team defensive back. */
    TEAM_DEFENSIVE_BACK("TMDB"),

    /** The team defense. */
    TEAM_DEFENSE("Def"),

    /** The special teams. */
    SPECIAL_TEAMS("ST"),

    /** The team offense. */
    TEAM_OFFENSE("Off"),

    /** Position unknown. */
    UNKNOWN("XX");

    /** The type. */
    private String type;

    /**
     * Instantiates a new position type.
     *
     * @param type the type
     */
    private Position(final String type) {
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
      return LoggerFactory.getLogger(Position.class);
    }

    /**
     * Creates an instance of this enumeration from an input string.  This input corresponds to the value of the
     * "position" attribute on an MFL "player" and "league" exports.
     *
     * @param pos the pos
     * @return the position
     */
    @JsonCreator
    public static Position fromValue(final String pos) {

    	// iterate the list to make sure we're getting the right entry.
        if (StringUtils.isNotBlank(pos)) {
            for(Position type : Position.values()) {
                if (pos.equalsIgnoreCase(type.getType())) {
                    return type;
                }
            }

            getLogger().warn("{} is an invalid value.", pos);
        }
        else {
        	getLogger().warn("A value was not provided.");
        }

        return UNKNOWN;
    }

	/**
	 * Checks if is an IDP position.
	 *
	 * @return true, if is idp
	 */
    // jd - ignoring cyclomatic complexity.  Pretty obvious why.
    // CHECKSTYLE:OFF
	public boolean isIDP() {
	// CHECKSTYLE:ON

		switch (this) {

			case DEFENSIVE_LINEMAN:
			case DEFENSIVE_TACKLE:
			case DEFENSIVE_END:
			case TEAM_DEFENSIVE_LINE:
			case LINEBACKER:
			case TEAM_LINEBACKER:
			case DEFENSIVE_BACK:
			case CORNERBACK:
			case SAFETY:
			case TEAM_DEFENSIVE_BACK:
				return true;

			default:
				return false;
		}
	}
}

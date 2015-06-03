package org.tiltedwindmills.fantasy.mfl.model.league;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;
import org.tiltedwindmills.fantasy.mfl.model.Position;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PositionRequirement.
 */
public class PositionRequirement extends AbstractObject {

	/** The serialVersionUID. */
	private static final long serialVersionUID = -5521282256134939329L;

	/** The position. */
	@JsonProperty("name")
	private Position position;

	/** The limit. */
	private String limit;

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public final Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public final void setPosition(final Position position) {
		this.position = position;
	}

	/**
	 * Gets the limit.
	 *
	 * @return the limit
	 */
	public final String getLimit() {
		return limit;
	}

	/**
	 * Sets the limit.
	 *
	 * @param limit the new limit
	 */
	public final void setLimit(final String limit) {
		this.limit = limit;
	}
}

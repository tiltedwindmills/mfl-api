package org.tiltedwindmills.fantasy.mfl.model.league;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

/**
 * A league conference.
 */
public class Conference extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8696139964241524475L;

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public final int getId() {

		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public final void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public final void setName(final String name) {
		this.name = name;
	}
}

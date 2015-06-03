package org.tiltedwindmills.fantasy.mfl.model.league;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

/**
 * A league division.
 */
public class Division extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7483529387545478334L;

	/** The id. */
	private Integer id;

	/** The name. */
	private String name;

	/** The conference for this division. */
	private Integer conference;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public final Integer getId() {

		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public final void setId(final Integer id) {
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

	/**
	 * Gets the conference.
	 *
	 * @return the conference
	 */
	public final Integer getConference() {
		return conference;
	}

	/**
	 * Sets the conference.
	 *
	 * @param conference the new conference
	 */
	public final void setConference(final Integer conference) {
		this.conference = conference;
	}
}

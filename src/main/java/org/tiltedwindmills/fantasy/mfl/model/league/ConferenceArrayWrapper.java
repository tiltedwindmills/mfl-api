package org.tiltedwindmills.fantasy.mfl.model.league;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ConferenceArrayWrapper.
 */
public class ConferenceArrayWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5820525545074015257L;

	/** The conferences. */
	@JsonProperty("conference")
	private List<Conference> conferences;

	/** The count. */
	@JsonProperty("count")
	private int count;

	/**
	 * Gets the conferences.
	 *
	 * @return the conferences
	 */
	public final List<Conference> getConferences() {
		if (conferences == null) {
			conferences = new ArrayList<Conference>();
		}
		return conferences;
	}

	/**
	 * Sets the conferences.
	 *
	 * @param conferences the new conferences
	 */
	public final void setConferences(final List<Conference> conferences) {
		this.conferences = conferences;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public final int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public final void setCount(final int count) {
		this.count = count;
	}
}

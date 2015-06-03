package org.tiltedwindmills.fantasy.mfl.model.league;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class DivisionArrayWrapper.
 */
public class DivisionArrayWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6773926415202457632L;

	/** The franchises. */
	@JsonProperty("division")
	private List<Division> divisions;

	/** The count. */
	@JsonProperty("count")
	private int count;

	/**
	 * Gets the divisions.
	 *
	 * @return the divisions
	 */
	public final List<Division> getDivisions() {
		if (divisions == null) {
			divisions = new ArrayList<Division>();
		}
		return divisions;
	}

	/**
	 * Sets the divisions.
	 *
	 * @param divisions the new divisions
	 */
	public final void setDivisions(final List<Division> divisions) {
		this.divisions = divisions;
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

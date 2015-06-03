package org.tiltedwindmills.fantasy.mfl.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class FranchiseArrayWrapper.
 */
public class FranchiseArrayWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7284935512916845685L;

	/** The franchises. */
	@JsonProperty("franchise")
	private ArrayList<Franchise> franchises;

	/** The count. */
	@JsonProperty("count")
	private int count;

	/**
	 * Gets the franchises.
	 *
	 * @return the franchises
	 */
	public final ArrayList<Franchise> getFranchises() {
		if (franchises == null) {
			franchises = new ArrayList<Franchise>();
		}
		return franchises;
	}

	/**
	 * Sets the franchises.
	 *
	 * @param franchises the new franchises
	 */
	public final void setFranchises(final ArrayList<Franchise> franchises) {
		this.franchises = franchises;
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

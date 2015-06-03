package org.tiltedwindmills.fantasy.mfl.model.rosters;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class RostersWrapper.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RostersWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1863034529920626580L;

	/** The franchise list. */
	@JsonProperty("franchise")
	private List<RosterFranchise> franchiseList;

	/**
	 * Gets the franchise list.
	 *
	 * @return the franchise list
	 */
	public final List<RosterFranchise> getFranchiseList() {
		return franchiseList;
	}

	public final void setFranchiseList(final List<RosterFranchise> franchiseList) {
		this.franchiseList = franchiseList;
	}
}

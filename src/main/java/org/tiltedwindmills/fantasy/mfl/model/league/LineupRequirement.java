package org.tiltedwindmills.fantasy.mfl.model.league;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LineupRequirement.
 */
public class LineupRequirement extends AbstractObject {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 5934681567288287442L;

	/** The total starters. */
	@JsonProperty("count")
	private String totalStarters;

	/** The idp starters. */
	@JsonProperty("idp_starters")
	private int idpStarters;

	/** The position requirements. */
	@JsonProperty("position")
	private List<PositionRequirement> positionRequirements;

	/**
	 * Gets the total starters.
	 *
	 * @return the total starters
	 */
	public final String getTotalStarters() {
		return totalStarters;
	}

	/**
	 * Sets the total starters.
	 *
	 * @param totalStarters the new total starters
	 */
	public final void setTotalStarters(final String totalStarters) {
		this.totalStarters = totalStarters;
	}

	/**
	 * Gets the idp starters.
	 *
	 * @return the idp starters
	 */
	public final int getIdpStarters() {
		return idpStarters;
	}

	/**
	 * Sets the idp starters.
	 *
	 * @param idpStarters the new idp starters
	 */
	public final void setIdpStarters(final int idpStarters) {
		this.idpStarters = idpStarters;
	}

	/**
	 * Gets the position requirements.
	 *
	 * @return the position requirements
	 */
	public final List<PositionRequirement> getPositionRequirements() {
		if (positionRequirements == null) {
			positionRequirements = new ArrayList<PositionRequirement>();
		}
		return positionRequirements;
	}

	/**
	 * Sets the position requirements.
	 *
	 * @param positionRequirements the new position requirements
	 */
	public final void setPositionRequirements(final List<PositionRequirement> positionRequirements) {
		this.positionRequirements = positionRequirements;
	}
}

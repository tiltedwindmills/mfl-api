package org.tiltedwindmills.fantasy.mfl.model;

import org.tiltedwindmills.fantasy.mfl.model.league.ConferenceArrayWrapper;
import org.tiltedwindmills.fantasy.mfl.model.league.DivisionArrayWrapper;
import org.tiltedwindmills.fantasy.mfl.model.league.LineupRequirement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class League.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class League extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7991024525559402505L;

	/** The id. */
	private int id;

	/** The server id. */
	@JsonIgnore
	private int serverId;

	/** The franchise id. */
	@JsonIgnore
	private String franchiseId;

	/** The name. */
	private String name;

	/** The roster size. */
	private String rosterSize;

	/** The head to head type. */
	@JsonProperty("h2h")
	private H2HType headToHeadType;

	/** The franchise list. */
	@JsonProperty("franchises")
	private FranchiseArrayWrapper franchiseList;

	/** The divisions list. */
	@JsonProperty("divisions")
	private DivisionArrayWrapper divisionList;

	/** The conference list. */
	@JsonProperty("conferences")
	private ConferenceArrayWrapper conferenceList;

	/** The starting lineup requirements. */
	@JsonProperty("starters")
	private LineupRequirement lineupRequirements;

	/** The start week. */
	private int startWeek;

	/** The end week. */
	private int endWeek;

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
	 * Gets the franchise list.
	 *
	 * @return the franchise list
	 */
	public final FranchiseArrayWrapper getFranchiseList() {
		return franchiseList;
	}

	/**
	 * Sets the franchise list.
	 *
	 * @param franchiseList the new franchise list
	 */
	public final void setFranchiseList(final FranchiseArrayWrapper franchiseList) {
		this.franchiseList = franchiseList;
	}

	/**
	 * Gets the roster size.
	 *
	 * @return the roster size
	 */
	public final String getRosterSize() {
		return rosterSize;
	}

	/**
	 * Sets the roster size.
	 *
	 * @param rosterSize the new roster size
	 */
	public final void setRosterSize(final String rosterSize) {
		this.rosterSize = rosterSize;
	}

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
	 * Gets the server id.
	 *
	 * @return the server id
	 */
	public final int getServerId() {
		return serverId;
	}

	/**
	 * Sets the server id.
	 *
	 * @param serverId the new server id
	 */
	public final void setServerId(final int serverId) {
		this.serverId = serverId;
	}

	/**
	 * Gets the head to head type.
	 *
	 * @return the head to head type
	 */
	public final H2HType getHeadToHeadType() {
		return headToHeadType;
	}

	/**
	 * Sets the head to head type.
	 *
	 * @param headToHeadType the new head to head type
	 */
	public final void setHeadToHeadType(final H2HType headToHeadType) {
		this.headToHeadType = headToHeadType;
	}

	/**
	 * Gets the franchise id.
	 *
	 * @return the franchise id
	 */
	public final String getFranchiseId() {
		return franchiseId;
	}

	/**
	 * Sets the franchise id.
	 *
	 * @param franchiseId the new franchise id
	 */
	public final void setFranchiseId(final String franchiseId) {
		this.franchiseId = franchiseId;
	}

	/**
	 * Gets the division list.
	 *
	 * @return the division list
	 */
	public final DivisionArrayWrapper getDivisionList() {
		return divisionList;
	}

	/**
	 * Sets the division list.
	 *
	 * @param divisionList the new division list
	 */
	public final void setDivisionList(final DivisionArrayWrapper divisionList) {
		this.divisionList = divisionList;
	}

	/**
	 * Gets the conference list.
	 *
	 * @return the conference list
	 */
	public final ConferenceArrayWrapper getConferenceList() {
		return conferenceList;
	}

	/**
	 * Sets the conference list.
	 *
	 * @param conferenceList the new conference list
	 */
	public final void setConferenceList(final ConferenceArrayWrapper conferenceList) {
		this.conferenceList = conferenceList;
	}

	/**
	 * Gets the lineup requirements.
	 *
	 * @return the lineup requirements
	 */
	public final LineupRequirement getLineupRequirements() {
		return lineupRequirements;
	}

	/**
	 * Sets the lineup requirements.
	 *
	 * @param lineupRequirements the new lineup requirements
	 */
	public final void setLineupRequirements(final LineupRequirement lineupRequirements) {
		this.lineupRequirements = lineupRequirements;
	}

	/**
	 * Gets the start week.
	 *
	 * @return the start week
	 */
	public final int getStartWeek() {
		return startWeek;
	}

	/**
	 * Sets the start week.
	 *
	 * @param startWeek the new start week
	 */
	public final void setStartWeek(final int startWeek) {
		this.startWeek = startWeek;
	}

	/**
	 * Gets the end week.
	 *
	 * @return the end week
	 */
	public final int getEndWeek() {
		return endWeek;
	}

	/**
	 * Sets the end week.
	 *
	 * @param endWeek the new end week
	 */
	public final void setEndWeek(final int endWeek) {
		this.endWeek = endWeek;
	}
}

package org.tiltedwindmills.fantasy.mfl.model.nflSchedule;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <team id="NOS" isHome="0" score="" rushDefenseRank="18" passDefenseRank="2" rushOffenseRank="24" passOffenseRank="2"
 * hasPossession="0" inRedZone="0" spread="2.5"/>
 */
public class NFLTeam extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8793227324592275776L;

	/** The franchise id. */
	@JsonProperty("id")
	private String teamId;

	/** The is home. */
	private int isHome;

	/** The score. */
	private double score;

	/** The spread. */
	private double spread;

	/** The rush offense rank. */
	private int rushOffenseRank;

	/** The pass offense rank. */
	private int passOffenseRank;

	/** The rush defense rank. */
	private int rushDefenseRank;

	/** The pass defense rank. */
	private int passDefenseRank;

	/** The has possession. */
	private int hasPossession;

	/** The in red zone. */
	private int inRedZone;

	/**
	 * Gets the team id.
	 *
	 * @return the team id
	 */
	public final String getTeamId() {
		return teamId;
	}

	/**
	 * Sets the team id.
	 *
	 * @param teamId the new team id
	 */
	public final void setTeamId(final String teamId) {
		this.teamId = teamId;
	}

	/**
	 * Gets the checks if is home.
	 *
	 * @return the checks if is home
	 */
	public final int getIsHome() {
		return isHome;
	}

	/**
	 * Sets the checks if is home.
	 *
	 * @param isHome the new checks if is home
	 */
	public final void setIsHome(final int isHome) {
		this.isHome = isHome;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public final double getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public final void setScore(final double score) {
		this.score = score;
	}

	/**
	 * Gets the spread.
	 *
	 * @return the spread
	 */
	public final double getSpread() {
		return spread;
	}

	/**
	 * Sets the spread.
	 *
	 * @param spread the new spread
	 */
	public final void setSpread(final double spread) {
		this.spread = spread;
	}

	/**
	 * Gets the rush offense rank.
	 *
	 * @return the rush offense rank
	 */
	public final int getRushOffenseRank() {
		return rushOffenseRank;
	}

	/**
	 * Sets the rush offense rank.
	 *
	 * @param rushOffenseRank the new rush offense rank
	 */
	public final void setRushOffenseRank(final int rushOffenseRank) {
		this.rushOffenseRank = rushOffenseRank;
	}

	/**
	 * Gets the pass offense rank.
	 *
	 * @return the pass offense rank
	 */
	public final int getPassOffenseRank() {
		return passOffenseRank;
	}

	/**
	 * Sets the pass offense rank.
	 *
	 * @param passOffenseRank the new pass offense rank
	 */
	public final void setPassOffenseRank(final int passOffenseRank) {
		this.passOffenseRank = passOffenseRank;
	}

	/**
	 * Gets the rush defense rank.
	 *
	 * @return the rush defense rank
	 */
	public final int getRushDefenseRank() {
		return rushDefenseRank;
	}

	/**
	 * Sets the rush defense rank.
	 *
	 * @param rushDefenseRank the new rush defense rank
	 */
	public final void setRushDefenseRank(final int rushDefenseRank) {
		this.rushDefenseRank = rushDefenseRank;
	}

	/**
	 * Gets the pass defense rank.
	 *
	 * @return the pass defense rank
	 */
	public final int getPassDefenseRank() {
		return passDefenseRank;
	}

	/**
	 * Sets the pass defense rank.
	 *
	 * @param passDefenseRank the new pass defense rank
	 */
	public final void setPassDefenseRank(final int passDefenseRank) {
		this.passDefenseRank = passDefenseRank;
	}

	/**
	 * Gets the checks for possession.
	 *
	 * @return the checks for possession
	 */
	public final int getHasPossession() {
		return hasPossession;
	}

	/**
	 * Sets the checks for possession.
	 *
	 * @param hasPossession the new checks for possession
	 */
	public final void setHasPossession(final int hasPossession) {
		this.hasPossession = hasPossession;
	}

	/**
	 * Gets the in red zone.
	 *
	 * @return the in red zone
	 */
	public final int getInRedZone() {
		return inRedZone;
	}

	/**
	 * Sets the in red zone.
	 *
	 * @param inRedZone the new in red zone
	 */
	public final void setInRedZone(final int inRedZone) {
		this.inRedZone = inRedZone;
	}
}

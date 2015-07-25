package org.tiltedwindmills.fantasy.mfl.model.rosters;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO : should be called "FranchiseRoster" ?
public class RosterFranchise extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6842083917847011225L;

	/** The franchise id. */
	private String id;

	@JsonProperty("player")
	private List<RosterPlayer> players;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public final void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public final List<RosterPlayer> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public final void setPlayers(final List<RosterPlayer> players) {
		this.players = players;
	}
}

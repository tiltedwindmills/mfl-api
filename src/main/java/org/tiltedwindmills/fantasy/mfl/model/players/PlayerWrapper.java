package org.tiltedwindmills.fantasy.mfl.model.players;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;
import org.tiltedwindmills.fantasy.mfl.model.Player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerWrapper.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4941340784868227642L;

	/** The timestamp. */
	private String timestamp;

	/** The players. */
	@JsonProperty("player")
	private List<Player> players;

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public final String getTimestamp() {

		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public final void setTimestamp(final String timestamp) {

		this.timestamp = timestamp;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public final List<Player> getPlayers() {

		if (players == null) {
			players = new ArrayList<Player>();
		}
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public final void setPlayers(final List<Player> players) {

		this.players = players;
	}
}

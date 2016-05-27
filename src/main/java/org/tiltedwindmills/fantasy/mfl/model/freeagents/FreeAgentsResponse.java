package org.tiltedwindmills.fantasy.mfl.model.freeagents;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonIgnoreProperties({ "encoding", "version" })
public class FreeAgentsResponse extends AbstractObject {

	private static final long serialVersionUID = 7736377212480537517L;

	@JsonProperty("freeAgents")
	@JsonDeserialize(converter = FreeAgentPlayerIdDeserializer.class)
	private List<String> playerIds;

	/**
	 * Gets the player ids.
	 *
	 * @return the player ids
	 */
	public List<String> getPlayerIds() {
		if (playerIds == null) {
			playerIds = new ArrayList<>();
		}
		return playerIds;
	}

	/**
	 * Sets the player ids.
	 *
	 * @param playerIds the new player ids
	 */
	public void setPlayerIds(final List<String> playerIds) {
		this.playerIds = playerIds;
	}
}

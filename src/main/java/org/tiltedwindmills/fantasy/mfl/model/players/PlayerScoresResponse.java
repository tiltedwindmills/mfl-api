package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerScoresResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerScoresResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4397287933820446828L;

	/** The wrapper. */
	@JsonProperty("playerScores")
	private PlayerScoresWrapper wrapper;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final PlayerScoresWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final PlayerScoresWrapper wrapper) {
		this.wrapper = wrapper;
	}
}

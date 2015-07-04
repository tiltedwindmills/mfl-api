package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PlayerResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6853588263032133021L;

	/** The wrapper. */
	@JsonProperty("players")
	private PlayerWrapper wrapper;

	/** The error. */
	@JsonProperty("error")
	private PlayerErrorMessage error;

	/**
	 * Gets the wrapper.
	 *
	 * @return the wrapper
	 */
	public final PlayerWrapper getWrapper() {
		return wrapper;
	}

	/**
	 * Sets the wrapper.
	 *
	 * @param wrapper the new wrapper
	 */
	public final void setWrapper(final PlayerWrapper wrapper) {
		this.wrapper = wrapper;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public final PlayerErrorMessage getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public final void setError(final PlayerErrorMessage error) {
		this.error = error;
	}
}

package org.tiltedwindmills.fantasy.mfl.model.players;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates errors from the Players API call.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerErrorMessage extends AbstractObject {

	/** The serialVersionUID. */
	private static final long serialVersionUID = -1534666012285453653L;

	/** The message. */
	@JsonProperty("$t")
	private String message;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public final String getMessage() {

		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public final void setMessage(final String message) {

		this.message = message;
	}
}

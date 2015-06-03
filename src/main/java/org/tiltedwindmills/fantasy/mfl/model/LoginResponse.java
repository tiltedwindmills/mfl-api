package org.tiltedwindmills.fantasy.mfl.model;


/**
 * Encapsulates the response from a request to the "login" MFL api.
 */
public class LoginResponse extends AbstractObject {

	/** serial version UID. */
	private static final long serialVersionUID = -1794087561382068430L;

	/** Is successful? */
	private boolean success;

	/** The message. */
	private String message;

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public final boolean isSuccess() {

		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public final void setSuccess(final boolean success) {

		this.success = success;
	}

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

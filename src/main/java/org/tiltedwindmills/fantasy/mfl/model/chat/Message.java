package org.tiltedwindmills.fantasy.mfl.model.chat;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

/**
 * Class encompasing a chat message from the MFL API.
 */
public class Message extends AbstractObject {

	/** The serialVersionUID. */
	private static final long serialVersionUID = -8104549213054169738L;

	/** The posted. */
	private String posted;

	/** The posted by. */
	private String postedBy;

	/** The posted to. */
	private String postedTo;

	/** The message id. */
	private String messageId;

	/** The message. */
	private String message;

	/**
	 * Gets the posted.
	 *
	 * @return the posted
	 */
	public final String getPosted() {

		return posted;
	}

	/**
	 * Sets the posted.
	 *
	 * @param posted the new posted
	 */
	public final void setPosted(final String posted) {

		this.posted = posted;
	}

	/**
	 * Gets the posted by.
	 *
	 * @return the posted by
	 */
	public final String getPostedBy() {

		return postedBy;
	}

	/**
	 * Sets the posted by.
	 *
	 * @param postedBy the new posted by
	 */
	public final void setPostedBy(final String postedBy) {

		this.postedBy = postedBy;
	}

	/**
	 * Gets the posted to.
	 *
	 * @return the posted to
	 */
	public final String getPostedTo() {

		return postedTo;
	}

	/**
	 * Sets the posted to.
	 *
	 * @param postedTo the new posted to
	 */
	public final void setPostedTo(final String postedTo) {

		this.postedTo = postedTo;
	}

	/**
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public final String getMessageId() {

		return messageId;
	}

	/**
	 * Sets the message id.
	 *
	 * @param messageId the new message id
	 */
	public final void setMessageId(final String messageId) {

		this.messageId = messageId;
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

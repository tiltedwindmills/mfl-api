package org.tiltedwindmills.fantasy.mfl.services.exception;

/**
 * Custom exception for MFL Football app failures.
 */
public class MFLServiceException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5273787863432615863L;

	/**
	 * Instantiates a new mFL fantasy football exception.
	 */
	public MFLServiceException() {
		super();
	}

	/**
	 * Instantiates a new mFL fantasy football exception.
	 *
	 * @param detailedMessage the detailed message
	 */
	public MFLServiceException(final String detailedMessage) {
		super(detailedMessage);
	}

	/**
	 * Instantiates a new mFL fantasy football exception.
	 *
	 * @param throwable the throwable
	 */
	public MFLServiceException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new mFL fantasy football exception.
	 *
	 * @param detailedMessage the detailed message
	 * @param throwable the throwable
	 */
	public MFLServiceException(final String detailedMessage, final Throwable throwable) {
		super(detailedMessage, throwable);
	}
}

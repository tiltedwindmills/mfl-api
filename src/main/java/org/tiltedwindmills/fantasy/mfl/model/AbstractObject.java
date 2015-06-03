package org.tiltedwindmills.fantasy.mfl.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Parent base class of all transfer/model objects, providing extension point and location for common functionality.
 *
 * This base class gives a vanilla implementation of toString, equals, hashCode and clone which are better than
 * you'll get from Object.  All of these methods can be overridden, thus there isn't a compelling reason to not have
 * all transfer objects extend this class.
 *
 */
public abstract class AbstractObject implements Serializable, Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4599533423915343386L;

	// This method is not final on purpose, it is a default implementation used most commonly
	// in generated transfer objects.  Checkstyle complains that this isn't final, but this is by design.
	//CHECKSTYLE:OFF
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	//CHECKSTYLE:ON
		return ToStringBuilder.reflectionToString(this);
	}
}

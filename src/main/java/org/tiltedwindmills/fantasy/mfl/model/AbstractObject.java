package org.tiltedwindmills.fantasy.mfl.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

	// NOTE:  These method are not final on purpose, they are default implementations used most commonly in transfer
	// objects.  Checkstyle complains about the methods not being final, but that is by design.  However, care should
	// be taken as turning off checkstyle as is done below can lead to missed findings.

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	//CHECKSTYLE:OFF
	@Override
	public String toString() {
	//CHECKSTYLE:ON
		return ToStringBuilder.reflectionToString(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	//CHECKSTYLE:OFF
	@Override
	public int hashCode() {
	//CHECKSTYLE:ON
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	//CHECKSTYLE:OFF
	@Override
	public boolean equals(Object obj) {
	//CHECKSTYLE:ON
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}

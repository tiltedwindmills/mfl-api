package org.tiltedwindmills.fantasy.mfl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Franchise.
 *
 * @author John Daniel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Franchise extends AbstractObject {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5569509644131422019L;

    /** The name. */
    private String name;

    /** The id. */
    private String id;

    /** The last visit. */
    private long lastVisit;

    /** The division. */
    private Integer division;

    /** The waiver order. */
    @JsonProperty("waiverSortOrder")
    private int waiverOrder;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the last visit.
     *
     * @return the last visit
     */
    public final long getLastVisit() {
        return lastVisit;
    }

    /**
     * Sets the last visit.
     *
     * @param lastVisit the new last visit
     */
    public final void setLastVisit(final long lastVisit) {
        this.lastVisit = lastVisit;
    }

    /**
     * Gets the division.
     *
     * @return the division
     */
    public final Integer getDivision() {
        return division;
    }

    /**
     * Sets the division.
     *
     * @param division the new division
     */
    public final void setDivision(final Integer division) {
        this.division = division;
    }

    /**
     * Gets the waiver sort order.
     *
     * @return the waiver sort order
     */
    public final int getWaiverOrder() {
        return waiverOrder;
    }

    /**
     * Sets the waiver sort order.
     *
     * @param waiverOrder the new waiver sort order
     */
    public final void setWaiverOrder(final int waiverOrder) {
        this.waiverOrder = waiverOrder;
    }
}

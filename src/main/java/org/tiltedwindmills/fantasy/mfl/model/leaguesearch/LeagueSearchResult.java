package org.tiltedwindmills.fantasy.mfl.model.leaguesearch;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LeagueSearchResult.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class LeagueSearchResult extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3570977558344505953L;

	/** The name. */
	private String name;

	/** The league ID. */
	private int id;

	/** The home URL. */
	@JsonProperty("homeURL")
	private String url;

	/** The selected. */
	@JsonIgnore
	private boolean selected;

	/**
	 * Default constructor.  Sets selected = true as default.
	 */
	public LeagueSearchResult() {
		selected = true;
	}

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
	public final int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public final void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the url to set
	 */
	public final void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Checks if is selected.
	 *
	 * @return the isSelected
	 */
	public final boolean isSelected() {

		return selected;
	}

	/**
	 * Sets the selected.
	 *
	 * @param selected the new selected
	 */
	public final void setSelected(final boolean selected) {

		this.selected = selected;
	}
}

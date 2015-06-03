package org.tiltedwindmills.fantasy.mfl.model.standings;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class StandingsWrapper.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsWrapper extends AbstractObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3396487264324237399L;

	/** The players. */
	@JsonProperty("franchise")
	private List<Standings> standings;

	/**
	 * Gets the standings.
	 *
	 * @return the standings
	 */
	public final List<Standings> getStandings() {

		if (standings == null) {
			standings = new ArrayList<Standings>();
		}
		return standings;
	}

	/**
	 * Sets the standings.
	 *
	 * @param standings the new standings
	 */
	public final void setStandings(final List<Standings> standings) {
		this.standings = standings;
	}
}

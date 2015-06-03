package org.tiltedwindmills.fantasy.mfl.model.draft;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Encapsulates a MFL "draft" export.
 *
 * @author John Daniel
 */
public class Draft extends AbstractObject {

	/* serialization UID */
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7367576115181908752L;

	/** The picks. */
	@JsonProperty("draftPick")
	private List<DraftPick> picks;

	/**
	 * Gets the picks.
	 *
	 * @return the picks
	 */
	public final List<DraftPick> getPicks() {

		if (picks == null) {
			picks = new ArrayList<DraftPick>();
		}

		return picks;
	}

	/**
	 * Sets the picks.
	 *
	 * @param picks the new picks
	 */
	public final void setPicks(final List<DraftPick> picks) {
		this.picks = picks;
	}
}

package org.tiltedwindmills.fantasy.mfl.model.draft;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DraftResultsWrapper extends AbstractObject {

	@JsonProperty("draftUnit")
	private List<Draft> drafts;

	public final List<Draft> getDrafts() {

		if (drafts == null) {
			drafts = new ArrayList<Draft>();
		}

		return drafts;
	}

	public final void setDrafts(final List<Draft> drafts) {
		this.drafts = drafts;
	}
}

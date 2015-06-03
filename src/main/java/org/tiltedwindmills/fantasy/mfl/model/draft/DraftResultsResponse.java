package org.tiltedwindmills.fantasy.mfl.model.draft;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Encapsulates the response from a request to the "draftResults" MFL export.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftResultsResponse extends AbstractObject {

	private static final long serialVersionUID = -8868848641310591325L;


	private DraftResultsWrapper draftResults;


	public final DraftResultsWrapper getDraftResults() {
		return draftResults;
	}

	public final void setDraftResults(final DraftResultsWrapper draftResults) {
		this.draftResults = draftResults;
	}
}

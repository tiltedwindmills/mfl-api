package org.tiltedwindmills.fantasy.mfl.model.draft;

import java.util.ArrayList;
import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DraftResultsWrapper extends AbstractObject {

    private static final long serialVersionUID = 1093761562824992783L;

    @JsonProperty("draftUnit")
    private List<Draft> drafts;

    /**
     * Gets the drafts.
     *
     * @return the drafts
     */
    public final List<Draft> getDrafts() {

        if (drafts == null) {
            drafts = new ArrayList<Draft>();
        }

        return drafts;
    }

    /**
     * Sets the drafts.
     *
     * @param drafts the new drafts
     */
    public final void setDrafts(final List<Draft> drafts) {
        this.drafts = drafts;
    }
}

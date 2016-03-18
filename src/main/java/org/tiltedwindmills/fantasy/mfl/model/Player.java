package org.tiltedwindmills.fantasy.mfl.model;

import java.util.Objects;

import org.joda.time.DateTime;
import org.joda.time.Years;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class encapsulating Player information.
 *
 * @author John Daniel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player extends AbstractObject {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 4397287933820446828L;

    /** The name. */
    private String name;

    /** The id. */
    private int id;

    /** The team. */
    private String team;

    /** The position. */
    private Position position;

    /** The draft year. */
    @JsonProperty("draft_year")
    private int draftYear;

    /** The draft round. */
    @JsonProperty("draft_round")
    private int draftRound;

    /** The draft pick. */
    @JsonProperty("draft_pick")
    private int draftPick;

    /** The draft team. */
    @JsonProperty("draft_team")
    private String draftTeam;

    /** The weight. */
    private int weight;

    /** The height. */
    private int height;

    /** The birthday. */
    @JsonProperty("birthdate")
    private long birthday;

    /** The college. */
    private String college;

    /** The jersey. */
    private int jersey;

    /** The twitter handle. */
    @JsonProperty("twitter_username")
    private String twitterHandle;

    /** The status. */
    private String status;

    /** The last updated. */
    @JsonIgnore
    private String lastUpdated;

    /**
     * Instantiates a new player with all default attributes.
     */
    public Player() {
        // no-op constructor
    }


    /**
     * Instantiates a new player using the provided attributes.
     *
     * @param name the name
     * @param id the id
     * @param team the team
     * @param position the position
     */
    public Player(final String name, final int id, final String team, final Position position) {

        this.name = name;
        this.id = id;
        this.team = team;
        this.position = position;
    }

    /**
     * Gets the age of a player at the start of the season based on the MFL provided birthday.
     *
     * @return the age
     */
    public final int getAge() {
        if (birthday <= 0) {
            return 0;
        }

        // jd - magic numbers related to specific conversion.  // TODO : use property value for kickoff date?
        // CHECKSTYLE:OFF
        final DateTime nflKickoff = new DateTime(2016,9,8,0,0);
        return Years.yearsBetween(new DateTime(birthday * 1000), nflKickoff).getYears();
        // CHECKSTYLE:ON
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
     * @param id the new id
     */
    public final void setId(final int id) {
        this.id = id;
    }


    /**
     * Gets the team.
     *
     * @return the team
     */
    public final String getTeam() {

        return team;
    }

    /**
     * Sets the team.
     *
     * @param team the new team
     */
    public final void setTeam(final String team) {

        this.team = team;
    }


    /**
     * Gets the position.
     *
     * @return the position
     */
    public final Position getPosition() {

        return position;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public final void setPosition(final Position position) {

        this.position = position;
    }

    /**
     * Gets the draft year.
     *
     * @return the draft year
     */
    public final int getDraftYear() {

        return draftYear;
    }

    /**
     * Sets the draft year.
     *
     * @param draftYear the new draft year
     */
    public final void setDraftYear(final int draftYear) {

        this.draftYear = draftYear;
    }

    /**
     * Gets the draft round.
     *
     * @return the draft round
     */
    public final int getDraftRound() {

        return draftRound;
    }

    /**
     * Sets the draft round.
     *
     * @param draftRound the new draft round
     */
    public final void setDraftRound(final int draftRound) {

        this.draftRound = draftRound;
    }

    /**
     * Gets the draft pick.
     *
     * @return the draft pick
     */
    public final int getDraftPick() {

        return draftPick;
    }

    /**
     * Sets the draft pick.
     *
     * @param draftPick the new draft pick
     */
    public final void setDraftPick(final int draftPick) {

        this.draftPick = draftPick;
    }

    /**
     * Gets the draft team.
     *
     * @return the draft team
     */
    public final String getDraftTeam() {

        return draftTeam;
    }

    /**
     * Sets the draft team.
     *
     * @param draftTeam the new draft team
     */
    public final void setDraftTeam(final String draftTeam) {

        this.draftTeam = draftTeam;
    }

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public final int getWeight() {

        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight the new weight
     */
    public final void setWeight(final int weight) {

        this.weight = weight;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public final int getHeight() {

        return height;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    public final void setHeight(final int height) {

        this.height = height;
    }

    /**
     * Gets the birthday.
     *
     * @return the birthday
     */
    public final long getBirthday() {

        return birthday;
    }

    /**
     * Sets the birthday.
     *
     * @param birthday the new birthday
     */
    public final void setBirthday(final long birthday) {

        this.birthday = birthday;
    }

    /**
     * Gets the college.
     *
     * @return the college
     */
    public final String getCollege() {

        return college;
    }

    /**
     * Sets the college.
     *
     * @param college the new college
     */
    public final void setCollege(final String college) {

        this.college = college;
    }

    /**
     * Gets the jersey.
     *
     * @return the jersey
     */
    public final int getJersey() {

        return jersey;
    }

    /**
     * Sets the jersey.
     *
     * @param jersey the new jersey
     */
    public final void setJersey(final int jersey) {

        this.jersey = jersey;
    }

    /**
     * Gets the twitter handle.
     *
     * @return the twitter handle
     */
    public final String getTwitterHandle() {

        return twitterHandle;
    }

    /**
     * Sets the twitter handle.
     *
     * @param twitterHandle the new twitter handle
     */
    public final void setTwitterHandle(final String twitterHandle) {

        this.twitterHandle = twitterHandle;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {

        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public final void setStatus(final String status) {

        this.status = status;
    }

    /**
     * Gets the last updated.
     *
     * @return the last updated
     */
    public final String getLastUpdated() {

        return lastUpdated;
    }

    /**
     * Sets the last updated.
     *
     * @param lastUpdated the new last updated
     */
    public final void setLastUpdated(final String lastUpdated) {

        this.lastUpdated = lastUpdated;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.tiltedwindmills.fantasy.mfl.model.AbstractObject#toString()
     */
    @Override
    public final String toString() {
        return (position == null ? "" : position.getType() + " ") + name + ", " + team;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode(){
        // hash code of a player is really just that of his ID.  Everything else is noise.
        return Objects.hashCode(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.tiltedwindmills.fantasy.mfl.model.AbstractObject#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {

        // could probably do just the ID here as well, but I'm being lazy.
        return super.equals(obj);
    }
}

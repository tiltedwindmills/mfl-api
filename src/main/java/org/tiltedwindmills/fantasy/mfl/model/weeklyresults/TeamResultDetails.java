package org.tiltedwindmills.fantasy.mfl.model.weeklyresults;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;
import org.tiltedwindmills.fantasy.mfl.services.util.BooleanDeserializer;
import org.tiltedwindmills.fantasy.mfl.services.util.CommaDelimitedStringToIntegerSetDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * An example:
 *
 * <pre>
 *  {
 *     player: [],
 *     optimal: "10077,4925,8360,11740,11293,3294,8359,10292,8684,8687,12215,9535,9083,11213,12171,10276,11175,",
 *     score: "116.7",
 *     spread: "-7.3",
 *     tiebreaker: "",
 *     isHome: "0",
 *     starters: "4925,11175,10276,10077,11200,7873,11670,8687,8359,12215,10292,9083,11293,8684,11740,11324,3294,",
 *     id: "0007",
 *     nonstarters: "11640,11210,11213,8493,8360,10289,11283,9535,11353,9847,10601,12150,9431,12171,12158,12257,9078,",
 *     result: "W"
 *  }
 * </pre>
 *
 * NOTE: The "tiebreaker" attribute is not currently supported.
 *
 * @author John Daniel
 */
public class TeamResultDetails extends AbstractObject {

    private static final long serialVersionUID = -2773320381100461542L;

    /** The franchise id. */
    @JsonProperty("id")
    private String franchiseId;

    /** The score. */
    private double score;

    private double spread;

    /** The home. */
    @JsonProperty("isHome")
    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean home;

    @JsonProperty("result")
    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean win;

    @JsonDeserialize(using = CommaDelimitedStringToIntegerSetDeserializer.class)
    private Set<Integer> optimal;

    @JsonDeserialize(using = CommaDelimitedStringToIntegerSetDeserializer.class)
    private Set<Integer> starters;

    @JsonProperty("nonstarters")
    @JsonDeserialize(using = CommaDelimitedStringToIntegerSetDeserializer.class)
    private Set<Integer> nonStarters;

    /** The player results. */
    @JsonProperty("player")
    private List<PlayerResultDetails> playerResults;

    /**
     * Gets the franchise id.
     *
     * @return the franchise id
     */
    public final String getFranchiseId() {
        return franchiseId;
    }

    /**
     * Sets the franchise id.
     *
     * @param franchiseId the new franchise id
     */
    public final void setFranchiseId(final String franchiseId) {
        this.franchiseId = franchiseId;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public final double getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score the new score
     */
    public final void setScore(final double score) {
        this.score = score;
    }

    /**
     * Checks if is home.
     *
     * @return the string
     */
    public final boolean isHome() {
        return home;
    }

    /**
     * Sets the home.
     *
     * @param home the new home
     */
    public final void setHome(final boolean home) {
        this.home = home;
    }

    /**
     * Gets the spread.
     *
     * @return the spread
     */
    public final double getSpread() {
        return spread;
    }

    /**
     * Sets the spread.
     *
     * @param spread the new spread
     */
    public final void setSpread(final double spread) {
        this.spread = spread;
    }

    /**
     * Checks if matchup is a win.
     *
     * @return true, if is win
     */
    public final boolean isWin() {
        return win;
    }

    /**
     * Sets if the matchup is a win.
     *
     * @param win the new win
     */
    public final void setWin(final boolean win) {
        this.win = win;
    }

    /**
     * Gets the optimal lineup.
     *
     * @return the optimal lineup
     */
    public final Set<Integer> getOptimal() {

        if (optimal == null) {
            optimal = new HashSet<>();
        }

        return optimal;
    }

    /**
     * Sets the optimal lineup.
     *
     * @param optimal the new optimal lineup
     */
    public final void setOptimal(final Set<Integer> optimal) {
        this.optimal = optimal;
    }

    /**
     * Gets the starting lineup.
     *
     * @return the starters
     */
    public final Set<Integer> getStarters() {

        if (starters == null) {
            starters = new HashSet<>();
        }

        return starters;
    }

    /**
     * Sets the starting lineup.
     *
     * @param starters the new starters
     */
    public final void setStarters(final Set<Integer> starters) {
        this.starters = starters;
    }

    /**
     * Gets the non starters.
     *
     * @return the non starters
     */
    public final Set<Integer> getNonStarters() {

        if (nonStarters == null) {
            nonStarters = new HashSet<>();
        }

        return nonStarters;
    }

    public final void setNonStarters(final Set<Integer> nonStarters) {
        this.nonStarters = nonStarters;
    }

    /**
     * Gets the player results.
     *
     * @return the player results
     */
    public final List<PlayerResultDetails> getPlayerResults() {

        if (playerResults == null) {
            playerResults = new ArrayList<PlayerResultDetails>();
        }

        return playerResults;
    }

    /**
     * Sets the player results.
     *
     * @param playerResults the new player results
     */
    public final void setPlayerResults(final List<PlayerResultDetails> playerResults) {
        this.playerResults = playerResults;
    }
}

package org.tiltedwindmills.fantasy.mfl.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class PlayerScoreTest {

    @Test
    public void setScoreAsStringTest() {

        // trivial test.  Primarily here to make sure moving the score to an int doesn't happen.

        PlayerScore playerScore = new PlayerScore();
        playerScore.setScore("");

        assertThat(playerScore.getScore(), is(""));
    }

    @Test
    public void getAggregateWeekTest() {

        // trivial test.  Primarily here to make sure moving the score to an int doesn't happen.

        PlayerScore playerScore = new PlayerScore();
        playerScore.setWeek("YTD");

        assertThat(playerScore.getWeek(), is("YTD"));
    }
}

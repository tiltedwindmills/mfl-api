package org.tiltedwindmills.fantasy.mfl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.model.H2HType}
 *
 * @author John Daniel
 */
public class PositionTest {

	@Test
	public void getCoachFromValueTest() {
		assertThat(Position.fromValue("Coach"), is(Position.HEAD_COACH));
	}

	@Test
	public void getCoachFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("cOaCh"), is(Position.HEAD_COACH));
	}

	@Test
	public void getQuarterbackFromValueTest() {
		assertThat(Position.fromValue("QB"), is(Position.QUARTERBACK));
	}

	@Test
	public void getQuarterbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("qb"), is(Position.QUARTERBACK));
	}

	@Test
	public void getTeamQuarterbackFromValueTest() {
		assertThat(Position.fromValue("TMQB"), is(Position.TEAM_QUARTERBACK));
	}

	@Test
	public void getTeamQuarterbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMqB"), is(Position.TEAM_QUARTERBACK));
	}

	@Test
	public void getRunningbackFromValueTest() {
		assertThat(Position.fromValue("RB"), is(Position.RUNNING_BACK));
	}

	@Test
	public void getRunningbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("rb"), is(Position.RUNNING_BACK));
	}

	@Test
	public void getTeamRunningbackFromValueTest() {
		assertThat(Position.fromValue("TMRB"), is(Position.TEAM_RUNNINGBACK));
	}

	@Test
	public void getTeamRunningbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMrB"), is(Position.TEAM_RUNNINGBACK));
	}

	@Test
	public void getFullbackFromValueTest() {
		assertThat(Position.fromValue("FB"), is(Position.FULL_BACK));
	}

	@Test
	public void getFullbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("fb"), is(Position.FULL_BACK));
	}

	@Test
	public void getReceiverFromValueTest() {
		assertThat(Position.fromValue("WR"), is(Position.WIDE_RECEIVER));
	}

	@Test
	public void getReceiverFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("wr"), is(Position.WIDE_RECEIVER));
	}

	@Test
	public void getTeamReceiverFromValueTest() {
		assertThat(Position.fromValue("TMWR"), is(Position.TEAM_WIDE_RECEIVER));
	}

	@Test
	public void getTeamReceiverFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMwR"), is(Position.TEAM_WIDE_RECEIVER));
	}

	@Test
	public void getTightEndFromValueTest() {
		assertThat(Position.fromValue("TE"), is(Position.TIGHT_END));
	}

	@Test
	public void getTightEndFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("te"), is(Position.TIGHT_END));
	}

	@Test
	public void getTeamTightEndFromValueTest() {
		assertThat(Position.fromValue("TMTE"), is(Position.TEAM_TIGHT_END));
	}

	@Test
	public void getTeamTightEndFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMtE"), is(Position.TEAM_TIGHT_END));
	}

	@Test
	public void getCombinedReceiverFromValueTest() {
		assertThat(Position.fromValue("WR+TE"), is(Position.COMBINED_RECEIVER));
	}

	@Test
	public void getCombinedReceiverFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("wR+tE"), is(Position.COMBINED_RECEIVER));
	}

	@Test
	public void getFlexFromValueTest() {
		assertThat(Position.fromValue("RB+WR+TE"), is(Position.FLEX));
	}

	@Test
	public void getFlexFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("rB+wR+tE"), is(Position.FLEX));
	}

	@Test
	public void getKickReturnerFromValueTest() {
		assertThat(Position.fromValue("KR"), is(Position.KICK_RETURNER));
	}

	@Test
	public void getKickReturnerFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("kr"), is(Position.KICK_RETURNER));
	}

	@Test
	public void getKickerFromValueTest() {
		assertThat(Position.fromValue("PK"), is(Position.KICKER));
	}

	@Test
	public void getKickerFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("pk"), is(Position.KICKER));
	}

	@Test
	public void getTeamKickerFromValueTest() {
		assertThat(Position.fromValue("TMPK"), is(Position.TEAM_KICKER));
	}

	@Test
	public void getTeamKickerFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMpK"), is(Position.TEAM_KICKER));
	}

	@Test
	public void getPunterFromValueTest() {
		assertThat(Position.fromValue("PN"), is(Position.PUNTER));
	}

	@Test
	public void getPunterFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("pn"), is(Position.PUNTER));
	}

	@Test
	public void getTeamPunterFromValueTest() {
		assertThat(Position.fromValue("TMPN"), is(Position.TEAM_PUNTER));
	}

	@Test
	public void getTeamPunterFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMpN"), is(Position.TEAM_PUNTER));
	}

	@Test
	public void getDefensiveTackleFromValueTest() {
		assertThat(Position.fromValue("DT"), is(Position.DEFENSIVE_TACKLE));
	}

	@Test
	public void getDefensiveTackleFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("dt"), is(Position.DEFENSIVE_TACKLE));
	}

	@Test
	public void getDefensiveEndFromValueTest() {
		assertThat(Position.fromValue("DE"), is(Position.DEFENSIVE_END));
	}

	@Test
	public void getDefensiveEndFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("de"), is(Position.DEFENSIVE_END));
	}

	@Test
	public void getDefensiveLinemanFromValueTest() {
		assertThat(Position.fromValue("DT+DE"), is(Position.DEFENSIVE_LINEMAN));
	}

	@Test
	public void getDefensiveLinemanFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("dT+dE"), is(Position.DEFENSIVE_LINEMAN));
	}

	@Test
	public void getTeamDefensiveLinemanFromValueTest() {
		assertThat(Position.fromValue("TMDL"), is(Position.TEAM_DEFENSIVE_LINE));
	}

	@Test
	public void getTeamDefensiveLinemanFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMdL"), is(Position.TEAM_DEFENSIVE_LINE));
	}

	@Test
	public void getLinebackerFromValueTest() {
		assertThat(Position.fromValue("LB"), is(Position.LINEBACKER));
	}

	@Test
	public void getLinebackerFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("lb"), is(Position.LINEBACKER));
	}

	@Test
	public void getTeamLinebackerFromValueTest() {
		assertThat(Position.fromValue("TMLB"), is(Position.TEAM_LINEBACKER));
	}

	@Test
	public void getTeamLinebackerFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMlB"), is(Position.TEAM_LINEBACKER));
	}

	@Test
	public void getCornerbackFromValueTest() {
		assertThat(Position.fromValue("CB"), is(Position.CORNERBACK));
	}

	@Test
	public void getCornerbackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("cb"), is(Position.CORNERBACK));
	}

	@Test
	public void getSafetyFromValueTest() {
		assertThat(Position.fromValue("S"), is(Position.SAFETY));
	}

	@Test
	public void getSafetyFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("s"), is(Position.SAFETY));
	}

	@Test
	public void getDefensiveBackFromValueTest() {
		assertThat(Position.fromValue("CB+S"), is(Position.DEFENSIVE_BACK));
	}

	@Test
	public void getDefensiveBackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("cB+s"), is(Position.DEFENSIVE_BACK));
	}

	@Test
	public void getTeamDefensiveBackFromValueTest() {
		assertThat(Position.fromValue("TMDB"), is(Position.TEAM_DEFENSIVE_BACK));
	}

	@Test
	public void getTeamDefensiveBackFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("tMdB"), is(Position.TEAM_DEFENSIVE_BACK));
	}

	@Test
	public void getTeamDefenseFromValueTest() {
		assertThat(Position.fromValue("Def"), is(Position.TEAM_DEFENSE));
	}

	@Test
	public void getTeamDefenseFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("dEf"), is(Position.TEAM_DEFENSE));
	}

	@Test
	public void getSpecialTeamsFromValueTest() {
		assertThat(Position.fromValue("ST"), is(Position.SPECIAL_TEAMS));
	}

	@Test
	public void getSpecialTeamsFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("st"), is(Position.SPECIAL_TEAMS));
	}

	@Test
	public void getTeamOffenseFromValueTest() {
		assertThat(Position.fromValue("Off"), is(Position.TEAM_OFFENSE));
	}

	@Test
	public void getTeamOffenseFromValueTestIgnoreCase() {
		assertThat(Position.fromValue("oFf"), is(Position.TEAM_OFFENSE));
	}

	@Test
	public void getUnknownFromValueTest() {
		assertThat(Position.fromValue("XX"), is(Position.UNKNOWN));
	}

	@Test
	public void getUnknownValueTestIgnoreCase() {
		assertThat(Position.fromValue("xx"), is(Position.UNKNOWN));
	}

	@Test
	public void getFromValueTestNull() {
		assertThat(Position.fromValue(null), is(Position.UNKNOWN));
	}

	@Test
	public void getFromValueTestEmpty() {
		assertThat(Position.fromValue(""), is(Position.UNKNOWN));
	}

	@Test
	public void getFromValueTestUnknown() {
		assertThat(Position.fromValue("some value"), is(Position.UNKNOWN));
	}
}

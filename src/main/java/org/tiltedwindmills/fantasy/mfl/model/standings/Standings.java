package org.tiltedwindmills.fantasy.mfl.model.standings;

import org.tiltedwindmills.fantasy.mfl.model.AbstractObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class encapsulating the standings results from a MFL API call. Options are:
 *
 * h2hw = Overall Wins
 * h2hl = Overall Losses
 * h2ht = Overall Ties
 * divw = Divisional Wins
 * divl = Divisional Losses
 * divt = Divisional Ties
 * divpf = Divisional Points For (Total Year-to-Date Points Scored In Divisional Games)
 * confw = Conference Wins
 * confl = Conference Losses
 * conft = Conference Ties
 * confpf = Conference Points For (Total Year-to-Date Points Scored In Conference Games)
 * pf = Points For (Total Year-to-Date Point Scored)
 * pa = Points Against (Total Year-to-Date Opponent Points Scored)
 * avgpa = Average Points Against (Weekly Average Opponent Points Scored)
 * maxpa = Maximum Points Against (Highest Weekly Points Against)
 * minpa = Minimum Points Against (Lowest Weekly Points Against)
 * pp = Potential Points
 * bbidspent = Total Amount Spent YTD On Blind Bidding
 * op = Offensive Points
 * dp = Defensive Points
 * pwr = Power Rank
 * acct = Accounting Balance
 * salary = Total Salary
 * vp = Victory Points
 * power_rank = The power rank for a franchise
 * all_play_w = The number of all-play wins
 * all_play_l = The number of all-play losses
 * all_play_t = The number of all-play ties
 *
 * Undocumented:
 * streak_type
 * streak_len
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings extends AbstractObject {

	/** serial version UID. */
	private static final long serialVersionUID = -2932030545897550986L;

	/** The franchise ID */
	@JsonProperty("id")
	private String franchiseId;

	/** The wins. */
	@JsonProperty("h2hw")
	private StandingsTValue wins;

	/** The losses. */
	@JsonProperty("h2hl")
	private StandingsTValue losses;

	/** The ties. */
	@JsonProperty("h2ht")
	private StandingsTValue ties;

	/** The division wins. */
	@JsonProperty("divw")
	private StandingsTValue divisionWins;

	/** The division losses. */
	@JsonProperty("divl")
	private StandingsTValue divisionLosses;

	/** The division ties. */
	@JsonProperty("divt")
	private StandingsTValue divisionTies;

	/** The division points for. */
	@JsonProperty("divpf")
	private StandingsTValue divisionPointsFor;

	/** The conference wins. */
	@JsonProperty("confw")
	private StandingsTValue conferenceWins;

	/** The conference losses. */
	@JsonProperty("confl")
	private StandingsTValue conferenceLosses;

	/** The conference ties. */
	@JsonProperty("conft")
	private StandingsTValue conferenceTies;

	/** The conference points for. */
	@JsonProperty("confpf")
	private StandingsTValue conferencePointsFor;

	/** The points for. */
	@JsonProperty("pf")
	private StandingsTValue pointsFor;

	/** The points against. */
	@JsonProperty("pa")
	private StandingsTValue pointsAgainst;

	/** The blind bidding spent. */
	@JsonProperty("bbidspent")
	private StandingsTValue blindBiddingSpent;

	/** The accounting balance. */
	@JsonProperty("acct")
	private StandingsTValue accountingBalance;

	/** The salary. */
	@JsonProperty("salary")
	private StandingsTValue salary;

	/** The power rank. */
	@JsonProperty("power_rank")
	private StandingsTValue powerRank;

	/** The victory points. */
	@JsonProperty("vp")
	private StandingsTValue victoryPoints;

	/** The all play wins. */
	@JsonProperty("all_play_w")
	private StandingsTValue allPlayWins;

	/** The all play losses. */
	@JsonProperty("all_play_l")
	private StandingsTValue allPlayLosses;

	/** The all play ties. */
	@JsonProperty("all_play_t")
	private StandingsTValue allPlayTies;

	/** The average points against. */
	@JsonProperty("avgpa")
	private StandingsTValue averagePointsAgainst;

	/** The max points against. */
	@JsonProperty("maxpa")
	private StandingsTValue maxPointsAgainst;

	/** The min points against. */
	@JsonProperty("minpa")
	private StandingsTValue minPointsAgainst;

	/** The potential points. */
	@JsonProperty("pp")
	private StandingsTValue potentialPoints;

	/** The offensive points. */
	@JsonProperty("op")
	private StandingsTValue offensivePoints;

	/** The defensive points. */
	@JsonProperty("dp")
	private StandingsTValue defensivePoints;

	/** The offensive points. */
	@JsonProperty("streak_type")
	private StandingsTValue streakType;

	/** The defensive points. */
	@JsonProperty("streak_len")
	private StandingsTValue streakLength;



	public final String getFranchiseId() {
		return franchiseId;
	}

	public final void setFranchiseId(final String franchiseId) {
		this.franchiseId = franchiseId;
	}


	/**
	 * Gets the wins.
	 *
	 * @return the wins
	 */
	public final String getWins() {
		if (wins == null || wins.getValue() == null) {
			return null;
		}
		return wins.getValue();
	}

	/**
	 * Sets the wins.
	 *
	 * @param wins the new wins
	 */
	public final void setWins(final StandingsTValue wins) {
		this.wins = wins;
	}

	/**
	 * Gets the losses.
	 *
	 * @return the losses
	 */
	public final String getLosses() {
		if (losses == null || losses.getValue() == null) {
			return null;
		}
		return losses.getValue();
	}

	/**
	 * Sets the losses.
	 *
	 * @param losses the new losses
	 */
	public final void setLosses(final StandingsTValue losses) {
		this.losses = losses;
	}

	/**
	 * Gets the ties.
	 *
	 * @return the ties
	 */
	public final String getTies() {
		if (ties == null || ties.getValue() == null) {
			return null;
		}
		return ties.getValue();
	}

	/**
	 * Sets the ties.
	 *
	 * @param ties the new ties
	 */
	public final void setTies(final StandingsTValue ties) {
		this.ties = ties;
	}

	/**
	 * Gets the division wins.
	 *
	 * @return the division wins
	 */
	public final String getDivisionWins() {
		if (divisionWins == null || divisionWins.getValue() == null) {
			return null;
		}
		return divisionWins.getValue();
	}

	/**
	 * Sets the division wins.
	 *
	 * @param divisionWins the new division wins
	 */
	public final void setDivisionWins(final StandingsTValue divisionWins) {
		this.divisionWins = divisionWins;
	}

	/**
	 * Gets the division losses.
	 *
	 * @return the division losses
	 */
	public final String getDivisionLosses() {
		if (divisionLosses == null || divisionLosses.getValue() == null) {
			return null;
		}
		return divisionLosses.getValue();
	}

	/**
	 * Sets the division losses.
	 *
	 * @param divisionLosses the new division losses
	 */
	public final void setDivisionLosses(final StandingsTValue divisionLosses) {
		this.divisionLosses = divisionLosses;
	}

	/**
	 * Gets the division ties.
	 *
	 * @return the division ties
	 */
	public final String getDivisionTies() {
		if (divisionTies == null || divisionTies.getValue() == null) {
			return null;
		}
		return divisionTies.getValue();
	}

	/**
	 * Sets the division ties.
	 *
	 * @param divisionTies the new division ties
	 */
	public final void setDivisionTies(final StandingsTValue divisionTies) {
		this.divisionTies = divisionTies;
	}

	/**
	 * Gets the division points for.
	 *
	 * @return the division points for
	 */
	public final String getDivisionPointsFor() {
		if (divisionPointsFor == null || divisionPointsFor.getValue() == null) {
			return null;
		}
		return divisionPointsFor.getValue();
	}

	/**
	 * Sets the division points for.
	 *
	 * @param divisionPointsFor the new division points for
	 */
	public final void setDivisionPointsFor(final StandingsTValue divisionPointsFor) {
		this.divisionPointsFor = divisionPointsFor;
	}

	/**
	 * Gets the conference wins.
	 *
	 * @return the conference wins
	 */
	public final String getConferenceWins() {
		if (conferenceWins == null || conferenceWins.getValue() == null) {
			return null;
		}
		return conferenceWins.getValue();
	}

	/**
	 * Sets the conference wins.
	 *
	 * @param conferenceWins the new conference wins
	 */
	public final void setConferenceWins(final StandingsTValue conferenceWins) {
		this.conferenceWins = conferenceWins;
	}

	/**
	 * Gets the conference losses.
	 *
	 * @return the conference losses
	 */
	public final String getConferenceLosses() {
		if (conferenceLosses == null || conferenceLosses.getValue() == null) {
			return null;
		}
		return conferenceLosses.getValue();
	}

	/**
	 * Sets the conference losses.
	 *
	 * @param conferenceLosses the new conference losses
	 */
	public final void setConferenceLosses(final StandingsTValue conferenceLosses) {
		this.conferenceLosses = conferenceLosses;
	}

	/**
	 * Gets the conference ties.
	 *
	 * @return the conference ties
	 */
	public final String getConferenceTies() {
		if (conferenceTies == null || conferenceTies.getValue() == null) {
			return null;
		}
		return conferenceTies.getValue();
	}

	/**
	 * Sets the conference ties.
	 *
	 * @param conferenceTies the new conference ties
	 */
	public final void setConferenceTies(final StandingsTValue conferenceTies) {
		this.conferenceTies = conferenceTies;
	}

	/**
	 * Gets the conference points for.
	 *
	 * @return the conference points for
	 */
	public final String getConferencePointsFor() {
		if (conferencePointsFor == null || conferencePointsFor.getValue() == null) {
			return null;
		}
		return conferencePointsFor.getValue();
	}

	/**
	 * Sets the conference points for.
	 *
	 * @param conferencePointsFor the new conference points for
	 */
	public final void setConferencePointsFor(final StandingsTValue conferencePointsFor) {
		this.conferencePointsFor = conferencePointsFor;
	}

	/**
	 * Gets the points for.
	 *
	 * @return the points for
	 */
	public final String getPointsFor() {
		if (pointsFor == null || pointsFor.getValue() == null) {
			return null;
		}
		return pointsFor.getValue();
	}

	/**
	 * Sets the points for.
	 *
	 * @param pointsFor the new points for
	 */
	public final void setPointsFor(final StandingsTValue pointsFor) {
		this.pointsFor = pointsFor;
	}

	/**
	 * Gets the points against.
	 *
	 * @return the points against
	 */
	public final String getPointsAgainst() {
		if (pointsAgainst == null || pointsAgainst.getValue() == null) {
			return null;
		}
		return pointsAgainst.getValue();
	}

	/**
	 * Sets the points against.
	 *
	 * @param pointsAgainst the new points against
	 */
	public final void setPointsAgainst(final StandingsTValue pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}

	/**
	 * Gets the blind bidding spent.
	 *
	 * @return the blind bidding spent
	 */
	public final String getBlindBiddingSpent() {
		if (blindBiddingSpent == null || blindBiddingSpent.getValue() == null) {
			return null;
		}
		return blindBiddingSpent.getValue();
	}

	/**
	 * Sets the blind bidding spent.
	 *
	 * @param blindBiddingSpent the new blind bidding spent
	 */
	public final void setBlindBiddingSpent(final StandingsTValue blindBiddingSpent) {
		this.blindBiddingSpent = blindBiddingSpent;
	}

	/**
	 * Gets the accounting balance.
	 *
	 * @return the accounting balance
	 */
	public final String getAccountingBalance() {
		if (accountingBalance == null || accountingBalance.getValue() == null) {
			return null;
		}
		return accountingBalance.getValue();
	}

	/**
	 * Sets the accounting balance.
	 *
	 * @param accountingBalance the new accounting balance
	 */
	public final void setAccountingBalance(final StandingsTValue accountingBalance) {
		this.accountingBalance = accountingBalance;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public final String getSalary() {
		if (salary == null || salary.getValue() == null) {
			return null;
		}
		return salary.getValue();
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public final void setSalary(final StandingsTValue salary) {
		this.salary = salary;
	}

	/**
	 * Gets the power rank.
	 *
	 * @return the power rank
	 */
	public final String getPowerRank() {
		if (powerRank == null || powerRank.getValue() == null) {
			return null;
		}
		return powerRank.getValue();
	}

	/**
	 * Sets the power rank.
	 *
	 * @param powerRank the new power rank
	 */
	public final void setPowerRank(final StandingsTValue powerRank) {
		this.powerRank = powerRank;
	}

	/**
	 * Gets the victory points.
	 *
	 * @return the victory points
	 */
	public final String getVictoryPoints() {
		if (victoryPoints == null || losses.getValue() == null) {
			return null;
		}
		return victoryPoints.getValue();
	}

	/**
	 * Sets the victory points.
	 *
	 * @param victoryPoints the new victory points
	 */
	public final void setVictoryPoints(final StandingsTValue victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	/**
	 * Gets the all play wins.
	 *
	 * @return the all play wins
	 */
	public final String getAllPlayWins() {
		if (allPlayWins == null || allPlayWins.getValue() == null) {
			return null;
		}
		return allPlayWins.getValue();
	}

	/**
	 * Sets the all play wins.
	 *
	 * @param allPlayWins the new all play wins
	 */
	public final void setAllPlayWins(final StandingsTValue allPlayWins) {
		this.allPlayWins = allPlayWins;
	}

	/**
	 * Gets the all play losses.
	 *
	 * @return the all play losses
	 */
	public final String getAllPlayLosses() {
		if (allPlayLosses == null || allPlayLosses.getValue() == null) {
			return null;
		}
		return allPlayLosses.getValue();
	}

	/**
	 * Sets the all play losses.
	 *
	 * @param allPlayLosses the new all play losses
	 */
	public final void setAllPlayLosses(final StandingsTValue allPlayLosses) {
		this.allPlayLosses = allPlayLosses;
	}

	/**
	 * Gets the all play ties.
	 *
	 * @return the all play ties
	 */
	public final String getAllPlayTies() {
		if (allPlayTies == null || allPlayTies.getValue() == null) {
			return null;
		}
		return allPlayTies.getValue();
	}

	/**
	 * Sets the all play ties.
	 *
	 * @param allPlayTies the new all play ties
	 */
	public final void setAllPlayTies(final StandingsTValue allPlayTies) {
		this.allPlayTies = allPlayTies;
	}

	/**
	 * Gets the average points against.
	 *
	 * @return the average points against
	 */
	public final String getAveragePointsAgainst() {
		if (averagePointsAgainst == null || averagePointsAgainst.getValue() == null) {
			return null;
		}
		return averagePointsAgainst.getValue();
	}

	/**
	 * Sets the average points against.
	 *
	 * @param averagePointsAgainst the new average points against
	 */
	public final void setAveragePointsAgainst(final StandingsTValue averagePointsAgainst) {
		this.averagePointsAgainst = averagePointsAgainst;
	}

	/**
	 * Gets the max points against.
	 *
	 * @return the max points against
	 */
	public final String getMaxPointsAgainst() {
		if (maxPointsAgainst == null || maxPointsAgainst.getValue() == null) {
			return null;
		}
		return maxPointsAgainst.getValue();
	}

	/**
	 * Sets the max points against.
	 *
	 * @param maxPointsAgainst the new max points against
	 */
	public final void setMaxPointsAgainst(final StandingsTValue maxPointsAgainst) {
		this.maxPointsAgainst = maxPointsAgainst;
	}

	/**
	 * Gets the min points against.
	 *
	 * @return the min points against
	 */
	public final String getMinPointsAgainst() {
		if (potentialPoints == null || potentialPoints.getValue() == null) {
			return null;
		}
		return potentialPoints.getValue();
	}

	/**
	 * Sets the min points against.
	 *
	 * @param minPointsAgainst the new min points against
	 */
	public final void setMinPointsAgainst(final StandingsTValue minPointsAgainst) {
		this.minPointsAgainst = minPointsAgainst;
	}

	/**
	 * Gets the potential points.
	 *
	 * @return the potential points
	 */
	public final String getPotentialPoints() {
		if (potentialPoints == null || potentialPoints.getValue() == null) {
			return null;
		}
		return potentialPoints.getValue();
	}

	/**
	 * Sets the potential points.
	 *
	 * @param potentialPoints the new potential points
	 */
	public final void setPotentialPoints(final StandingsTValue potentialPoints) {
		this.potentialPoints = potentialPoints;
	}

	/**
	 * Gets the offensive points.
	 *
	 * @return the offensive points
	 */
	public final String getOffensivePoints() {
		if (offensivePoints == null || offensivePoints.getValue() == null) {
			return null;
		}
		return offensivePoints.getValue();
	}

	/**
	 * Sets the offensive points.
	 *
	 * @param offensivePoints the new offensive points
	 */
	public final void setOffensivePoints(final StandingsTValue offensivePoints) {
		this.offensivePoints = offensivePoints;
	}

	/**
	 * Gets the defensive points.
	 *
	 * @return the defensive points
	 */
	public final String getDefensivePoints() {
		if (defensivePoints == null || defensivePoints.getValue() == null) {
			return null;
		}
		return defensivePoints.getValue();
	}

	/**
	 * Sets the defensive points.
	 *
	 * @param defensivePoints the new defensive points
	 */
	public final void setDefensivePoints(final StandingsTValue defensivePoints) {
		this.defensivePoints = defensivePoints;
	}

	/**
	 * Gets the streak type.
	 *
	 * @return the streak type
	 */
	public final String getStreakType() {
		if (streakType == null || streakType.getValue() == null) {
			return null;
		}
		return streakType.getValue();
	}

	/**
	 * Sets the streak type.
	 *
	 * @param streakType the new streak type
	 */
	public final void setStreakType(final StandingsTValue streakType) {
		this.streakType = streakType;
	}

	/**
	 * Gets the streak length.
	 *
	 * @return the streak length
	 */
	public final String getStreakLength() {
		if (streakLength == null || streakLength.getValue() == null) {
			return null;
		}
		return streakLength.getValue();
	}

	/**
	 * Sets the streak length.
	 *
	 * @param streakLength the new streak length
	 */
	public final void setStreakLength(final StandingsTValue streakLength) {
		this.streakLength = streakLength;
	}
}

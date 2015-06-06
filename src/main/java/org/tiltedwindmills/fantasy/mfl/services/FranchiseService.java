package org.tiltedwindmills.fantasy.mfl.services;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.rosters.RosterFranchise;

/**
 * Interface defining operations required for working with MFL Franchise entities.
 */
public interface FranchiseService {

	/**
	 * Gets the all rosters.
	 *
	 * @param mflLeagueId the mfl league id
	 * @param serverId the server id
	 * @param year the year
	 * @return the all rosters
	 */
	List<RosterFranchise> getAllRosters(int mflLeagueId, String serverId, int year);


	/**
	 * Gets the franchise roster.
	 *
	 * @param franchise the franchise
	 * @param mflLeagueId the mfl league id
	 * @param serverId the server id
	 * @param year the year
	 * @return the franchise roster
	 */
	RosterFranchise getFranchiseRoster(String franchise, int mflLeagueId, String serverId, int year);
}

package org.tiltedwindmills.fantasy.mfl.services;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.rosters.FranchiseRoster;

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
	List<FranchiseRoster> getAllRosters(int mflLeagueId, String serverId, int year);


	/**
	 * Gets the franchise roster.
	 *
	 * @param franchise the franchise
	 * @param mflLeagueId the mfl league id
	 * @param serverId the server id
	 * @param year the year
	 * @return the franchise roster
	 */
	FranchiseRoster getFranchiseRoster(String franchise, int mflLeagueId, String serverId, int year);
}

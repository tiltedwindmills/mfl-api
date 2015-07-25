package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.tiltedwindmills.fantasy.mfl.model.rosters.RostersResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Retrofit interface for MFL Franchise related API calls.
 */
public interface MflFranchiseExport {

	/**
	 * Gets the roster.
	 *
	 * @param league the league
	 * @param franchiseId the franchise id
	 * @param year the year
	 * @return the roster
	 */
	@GET("/{year}/export?TYPE=rosters&JSON=1")
	RostersResponse getRoster(@Query("L") int league, @Query("FRANCHISE") String franchiseId, @Path("year") int year);
}

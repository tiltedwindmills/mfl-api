package org.tiltedwindmills.fantasy.mfl.services.impl;

/**
 * The available Cache names for
 *
 * @author John Daniel
 */
public final class CacheNames {

	// no public constructor
	private CacheNames() { }


	/** The player cache. */
	public static final String PLAYERS = "playerCache";

	/** The league cache. */
	public static final String LEAGUES = "leagueCache";

	/** The league details cache.  Used for when a franchise and password are supplied for retrieval. */
	public static final String LEAGUE_DETAILS = "leagueDetailCache";

	/** The roster cache. */
	public static final String ROSTERS = "rosterCache";
}

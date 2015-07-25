package org.tiltedwindmills.fantasy.mfl.services;

import org.tiltedwindmills.fantasy.mfl.model.LoginResponse;


/**
 * Interface defining operations required for logging into an MFL league.
 */
public interface LoginService {

	/**
	 * Login.
	 *
	 * @param leagueId the league id
	 * @param serverId the server id
	 * @param year the year
	 * @param franchiseId the franchise id
	 * @param password the password
	 * @return the login response
	 */
	LoginResponse login(int leagueId, int serverId, int year, String franchiseId, String password);
}

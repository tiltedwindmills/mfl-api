package org.tiltedwindmills.fantasy.mfl.services;

import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule;

/**
 * Interface defining operations required for working with NFL entities.
 */
public interface NFLService {

	/**
	 * Gets the nFL schedule.
	 *
	 * @param week the week
	 * @param year the year
	 * @return the nFL schedule
	 */
	NFLSchedule getNFLSchedule(int week, int year);
}

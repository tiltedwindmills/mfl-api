package org.tiltedwindmills.fantasy.mfl.services;

import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule;

/**
 * Interface defining operations required for working with NFL entities.
 */
public interface NFLService {

	/**
	 * Gets the NFL schedule.
	 *
	 * @param week the week
	 * @param year the year
	 * @return the NFL schedule
	 */
	NFLSchedule getNFLSchedule(int week, int year);
}

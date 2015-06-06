package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLScheduleResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Retrofit interface for MFL NFL Schedule API call.
 */
public interface MflNflExport {

	/**
	 * Gets the NFL Schedule.
	 *
	 * @param week the week
	 * @param year the year
	 * @return the nFL schedule
	 */
	@GET("/{year}/export?TYPE=nflSchedule&JSON=1")
	NFLScheduleResponse getNFLSchedule(@Query("W") int week, @Path("year") int year);
}

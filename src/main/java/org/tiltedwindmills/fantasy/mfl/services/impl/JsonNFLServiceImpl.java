package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.springframework.stereotype.Service;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLScheduleResponse;
import org.tiltedwindmills.fantasy.mfl.services.NFLService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

/**
 * Implementation of the NFL service.
 */
@Service
public final class JsonNFLServiceImpl extends AbstractJsonServiceImpl implements NFLService {

	// no need to be server specific about player ops.
	private static final String SERVER_ID = "";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.jwdaniel.services.NFLService#getNFLSchedule(int, int)
	 */
	@Override
	public NFLSchedule getNFLSchedule(final int week, final int year) {

		final MflNflExport nflExport = getRestAdapter(SERVER_ID).create(MflNflExport.class);
		final NFLScheduleResponse nflScheduleResponse = nflExport.getNFLSchedule(week, year);

		if (nflScheduleResponse != null) {
			return nflScheduleResponse.getNflSchedule();
		}

		throw new MFLServiceException("Invalid NFL Schedule retrieved from MFL");
	}
}

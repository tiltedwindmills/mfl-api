package org.tiltedwindmills.fantasy.mfl.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLSchedule;
import org.tiltedwindmills.fantasy.mfl.model.nflschedule.NFLScheduleResponse;
import org.tiltedwindmills.fantasy.mfl.services.NFLService;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;

import retrofit.RetrofitError;

/**
 * Implementation of the NFL service.
 */
@Service
public final class JsonNFLServiceImpl extends AbstractJsonServiceImpl implements NFLService {

    private static final Logger LOG = LoggerFactory.getLogger(JsonNFLServiceImpl.class);

    /** no need to be server specific about NFL schedule ops. */
    private static final String SERVER_ID = "";

    /*
     * (non-Javadoc)
     *
     * @see com.jwdaniel.services.NFLService#getNFLSchedule(int, int)
     */
    @Override
    public NFLSchedule getNFLSchedule(final int week, final int year) {

        if (week <= 0 || year < FIRST_MFL_SUPPORTED_YEAR) {
            throw new MFLServiceException("Invalid parameters for NFL Schedule request");
        }

        try {

            final MflNflExport nflExport = getRestAdapter(SERVER_ID).create(MflNflExport.class);
            final NFLScheduleResponse nflScheduleResponse = nflExport.getNFLSchedule(week, year);

            if (nflScheduleResponse == null) {
                LOG.error("Invalid response retrieving NFL schedule for week {} & year {}.", week, year);
                throw new MFLServiceException("Invalid response retrieving NFL schedule.");

            } else {
                return nflScheduleResponse.getNflSchedule();
            }

        } catch (RetrofitError e) {
            LOG.error("Error retrieving NFL schedule data: {}", e.getMessage());
            throw new MFLServiceException("Error retrieving NFL schedule data", e);
        }
    }
}

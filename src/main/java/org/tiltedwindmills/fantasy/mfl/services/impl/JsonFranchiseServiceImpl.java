package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tiltedwindmills.fantasy.mfl.model.rosters.FranchiseRoster;
import org.tiltedwindmills.fantasy.mfl.model.rosters.RostersResponse;
import org.tiltedwindmills.fantasy.mfl.services.FranchiseService;

/**
 * JSON implementation of the {@link org.tiltedwindmills.fantasy.mfl.services.LeagueService}
 */
@Service
public final class JsonFranchiseServiceImpl extends AbstractJsonServiceImpl implements FranchiseService {

    /*
     * (non-Javadoc)
     *
     * @see com.jwdaniel.services.FranchiseService#getAllRosters(int, java.lang.String, int)
     */
    @Override
    public List<FranchiseRoster> getAllRosters(final int mflLeagueId, final String serverId, final int year) {

        final MflFranchiseExport franchiseExport = getRestAdapter(serverId).create(MflFranchiseExport.class);
        final RostersResponse rostersResponse = franchiseExport.getRoster(mflLeagueId, null, year);

        if (rostersResponse != null && rostersResponse.getWrapper() != null) {
            return rostersResponse.getWrapper().getFranchiseList();
        }

        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jwdaniel.services.FranchiseService#getFranchiseRoster(java.lang.String, int, java.lang.String, int)
     */
    @Override
    public FranchiseRoster getFranchiseRoster(final String franchise,
                                            final int mflLeagueId,
                                            final String serverId,
                                            final int year) {

        final MflFranchiseExport franchiseExport = getRestAdapter(serverId).create(MflFranchiseExport.class);
        final RostersResponse rostersResponse = franchiseExport.getRoster(mflLeagueId, franchise, year);

        if (rostersResponse != null && rostersResponse.getWrapper() != null) {
            return rostersResponse.getWrapper().getFranchiseList().get(0);
        }

        return null;
    }
}

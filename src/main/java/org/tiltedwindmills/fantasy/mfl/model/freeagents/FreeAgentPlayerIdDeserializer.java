package org.tiltedwindmills.fantasy.mfl.model.freeagents;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

/**
 * Parses the inbound JSON from MFL's export into a list of player IDs.
 *
 * @author John Daniel
 */
public class FreeAgentPlayerIdDeserializer implements Converter<Map<String, Object>, List<String>> {

	private static final Logger LOG = LoggerFactory.getLogger(FreeAgentPlayerIdDeserializer.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<String> convert(final Map<String, Object> value) {

		final List<String> playerIds = new ArrayList<>();

		final Map<String, Object> leagueUnits = (Map<String, Object>) value.get("leagueUnit");
		LOG.debug("League Units is {}", leagueUnits);

		final Object players = leagueUnits.get("player");
		if (players != null && players instanceof List) {

			final List<Map<String, Object>> playerIdMapList = (List<Map<String, Object>>) players;

			for (Map<String, Object> playerIdMap : playerIdMapList) {
				for (Object playerId : playerIdMap.values()) {
					playerIds.add((String) playerId);
				}
			}
		}

		return playerIds;
	}

	@Override
	public JavaType getInputType(final TypeFactory typeFactory) {
		return typeFactory.constructMapLikeType(Map.class, String.class, Object.class);
	}

	@Override
	public JavaType getOutputType(final TypeFactory typeFactory) {
		return typeFactory.constructCollectionLikeType(List.class, String.class);
	}
}
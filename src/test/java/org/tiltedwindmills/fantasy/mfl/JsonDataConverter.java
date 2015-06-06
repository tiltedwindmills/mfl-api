package org.tiltedwindmills.fantasy.mfl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.tiltedwindmills.fantasy.mfl.model.Player;
import org.tiltedwindmills.fantasy.mfl.model.players.PlayerResponse;
import org.tiltedwindmills.fantasy.mfl.services.impl.JsonPlayerServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDataConverter {

	private static final Logger LOG = LoggerFactory.getLogger(JsonDataConverter.class);


	public static final PlayerResponse players(final String fileName) {

		try {

			final Resource resource = new ClassPathResource("exports/players/" + fileName + ".json");
			final InputStream resourceInputStream = resource.getInputStream();

			return new ObjectMapper().readValue(resourceInputStream, PlayerResponse.class);

		} catch (IOException e) {
			LOG.error("Failed to load MFL players from file: {}", e.getMessage());
		}

		return null;
	}

}

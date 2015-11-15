package org.tiltedwindmills.fantasy.mfl.services.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Jackson deserializer used to turn an incoming comma-delimited list into a list of Integers.  This is used in
 * particular to translate the player ID strings in exports like the "weeklyResults" into lists of Player IDs.
 *
 * For example, the string : "1,2,3,4,5," will become a set with the values 1-5 inclusive.
 *
 * @author John Daniel
 */
public final class CommaDelimitedStringToIntegerSetDeserializer extends JsonDeserializer<Set<Integer>> {

    // TODO : needs testing

    private static final Logger LOG = LoggerFactory.getLogger(CommaDelimitedStringToIntegerSetDeserializer.class);

    /*
     * (non-Javadoc)
     *
     * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser,
     * com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public Set<Integer> deserialize(final JsonParser jsonParser, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {


        final JsonToken t = jsonParser.getCurrentToken();
        if (t == JsonToken.VALUE_STRING) {

            final String[] tokens = StringUtils.split( jsonParser.getText().trim(), ",");

            if (tokens != null) {

                final Set<Integer> integers = new HashSet<Integer>();

                for (String token : tokens) {

                    if (StringUtils.isNotBlank(token)) {
                        try {
                            integers.add(Integer.parseInt(token));
                        } catch (NumberFormatException e) {

                            // can just log this and move along.
                            LOG.warn("Could not parse value {}", token);
                        }
                    }
                }

                // finished parsing each entry.  return the results
                return integers;
            }
        }

        LOG.warn("Error deserializing value '{}'", jsonParser.getText());
        throw ctxt.mappingException(
                "Could not deserialize value '" + jsonParser.getText() + "' to Set of Integers. ");
    }
}

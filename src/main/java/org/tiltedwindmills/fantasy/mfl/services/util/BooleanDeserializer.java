package org.tiltedwindmills.fantasy.mfl.services.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Silly little Jackson deserializer used to turn MFL's string responses into booleans.  Presently, this will handle
 * "1"'s and "W"'s as {@code true}, and "0"'s and "L"'s as {@code false}.
 *
 * @author John Daniel
 */
public final class BooleanDeserializer extends JsonDeserializer<Boolean> {

    // TODO : needs testing

    /*
     * (non-Javadoc)
     *
     * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser,
     * com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public Boolean deserialize(final JsonParser jsonParser, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

//        try {
//            return BooleanUtils.toBooleanObject(Integer.parseInt(jsonParser.getText().trim()));
//
//        } catch (NumberFormatException | IOException e) {
//            throw ctxt.mappingException(
//                  "Could not deserialize value '" + jsonParser.getCurrentToken() + "' to Boolean. " + e.getMessage());
//        }

        final JsonToken t = jsonParser.getCurrentToken();
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return jsonParser.getIntValue() != 0;
        }
        else if (t == JsonToken.VALUE_STRING) {

            switch (jsonParser.getText().trim()) {

                case "0":
                case "L":
                    return false;

                case "1":
                case "W":
                    return true;

                default:
                    // do nothing, just fall through to exception generator.
            }
        }

        throw ctxt.mappingException(
                "Could not deserialize value '" + jsonParser.getText() + "' to Boolean. ");
    }
}

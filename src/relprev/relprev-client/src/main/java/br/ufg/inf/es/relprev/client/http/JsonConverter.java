package br.ufg.inf.es.relprev.client.http;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 10:26 PM
 */
public class JsonConverter {

    private JsonConverter() {}

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T fromJson(final String json, final Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Erro ao fazer o parse do json " + json, e);
        }
    }

    public static String toJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Erro ao fazer o parse do objeto" + object, e);
        }
    }

}

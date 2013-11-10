package br.ufg.inf.es.relprev.client.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 10:26 PM
 */
public class JsonConverter {
    ObjectMapper objectMapper = new ObjectMapper();

    public JsonConverter() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Object fromJson(String json, Class clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao fazer o parse do json " + json);
        }
    }

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao fazer o parse do objeto" + object);
        }
    }
}

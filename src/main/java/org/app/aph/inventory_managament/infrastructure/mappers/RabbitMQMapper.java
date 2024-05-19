package org.app.aph.inventory_managament.infrastructure.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RabbitMQMapper {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static String serialize(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T deserialize(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    public static <T> T deserialize(String json, TypeReference<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

}
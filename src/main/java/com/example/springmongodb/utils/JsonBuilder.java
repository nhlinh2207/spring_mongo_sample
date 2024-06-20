package com.example.springmongodb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String parseString(T object) throws JsonProcessingException {
        synchronized (mapper) {
            return mapper.writeValueAsString(object);
        }
    }
}

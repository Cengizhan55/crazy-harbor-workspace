package com.crazycoder.crazyharborcommon.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class JsonUtil {

    public String toJson(Object obj) {

        String jsonString = null;
        try {
            jsonString = getObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jsonString;
    }

    public <T> T toObject(String jsonData, Class<T> dataType) {

        try {
            return getObjectMapper().readValue(jsonData, dataType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> toObjectArray(String jsonData, Class<T> classInfo) {

        ObjectMapper mapper = new ObjectMapper();
        Class<T[]> arrayClass = null;


        try {
            arrayClass = (Class<T[]>) Class.forName("[L" + classInfo.getName() + ";");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        T[] objects = null;

        try {
            objects = mapper.readValue(jsonData, arrayClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(objects);


    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return objectMapper;
    }

}

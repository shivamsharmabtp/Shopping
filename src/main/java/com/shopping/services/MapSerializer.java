package com.shopping.services;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MapSerializer extends JsonSerializer<SpecialMap> {
    @Override
    public void serialize(SpecialMap map, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeStartObject();
        for (String key : map.keySet()) {
            jgen.writeStringField(key, map.get(key));
        }
        jgen.writeEndObject();
    }
}
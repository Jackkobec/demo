package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtil {
    public static final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static Object parceString(String value, TypeReference valueTypeRef) throws IOException {
        SimpleModule module = new JavaTimeModule()
                .addSerializer(ZonedDateTime.class,
                        new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        ObjectMapper mapper = new ObjectMapper().registerModule(module);
        return mapper.readValue(value, valueTypeRef);

    }

    public static Object parceString(String value, Class clazz) throws IOException {

        SimpleModule module = new JavaTimeModule()
                .addSerializer(ZonedDateTime.class,
                        new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        ObjectMapper mapper = new ObjectMapper().registerModule(module);
        return mapper.readValue(value, clazz);
    }

    public static String writeValueAsString(Object object) throws JsonProcessingException {
        SimpleModule module = new JavaTimeModule()
                .addDeserializer(LocalDate.class,
                        new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        ObjectMapper mapper = new ObjectMapper().registerModule(module);
        return mapper.writeValueAsString(object);

    }
}

package com.example.springmongodb.config;

import com.example.springmongodb.utils.ZonedDateTimeConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoTemplateConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new ZonedDateTimeConverters.DateToZonedDateTimeConverter(),
                new ZonedDateTimeConverters.ZonedDateTimeToDateConverter()
        ));
    }
}

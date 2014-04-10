package com.charlires.example.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by carlos_andonaegui on 4/10/14.
 */
@Configuration
@EnableWebMvc
public class RestConfig extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        // This changes json out put format
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        super.configureJacksonObjectMapper(objectMapper);
    }

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        // This disables the default jso+hal standard
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        super.configureRepositoryRestConfiguration(config);
    }

}

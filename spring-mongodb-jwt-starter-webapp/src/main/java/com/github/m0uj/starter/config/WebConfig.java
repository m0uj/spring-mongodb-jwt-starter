package com.github.m0uj.starter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by m0uj on 5/18/17.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * CORS support
     * TODO remove if not needed anymore
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
}

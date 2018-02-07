package com.github.m0uj.starter.config;

import com.github.jmnarloch.spring.boot.modelmapper.ModelMapperConfigurer;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Component;

/**
 * Created by m0uj on 6/13/17.
 */
@Component
public class CustomModelMapperConfigurer implements ModelMapperConfigurer {
    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setSourceNamingConvention(NamingConventions.NONE)
                .setDestinationNamingConvention(NamingConventions.NONE);
    }
}

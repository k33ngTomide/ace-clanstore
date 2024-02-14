package com.acaclan.aceclan;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.ModifierMatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

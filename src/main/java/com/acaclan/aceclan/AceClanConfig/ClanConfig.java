package com.acaclan.aceclan.AceClanConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

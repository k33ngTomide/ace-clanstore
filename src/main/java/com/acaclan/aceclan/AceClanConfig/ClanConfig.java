package com.acaclan.aceclan.AceClanConfig;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class ClanConfig {

    @Value("${cloudinary.api.name}")
    private String cloudinaryApiName;
    @Value("${cloudinary.api.key}")
    private String cloudinaryApiKey;
    @Value("${cloudinary.api.secret}")
    private String cloudinaryApiSecretKey;

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", getCloudinaryApiName(),
                        "api_key", getCloudinaryApiKey(),
                        "api_secret", getCloudinaryApiSecretKey()
                )
        );
    }

    @Bean
    public RestTemplate createTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

//package com.acaclan.aceclan.AceClanConfig;
//
//
//import org.springframework.context.annotation.Configuration;
//
//
//import java.util.Collections;
//
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Ace Clan API Docs",
//                "Ace clan story description of API.",
//                "API V1",
//                "Terms of service",
//                new Contact("Ace Clan", "www.aceclan.com", "aceclan@company.com"),
//                "License of API", "API license URL", Collections.emptyList()
//        );
//    }
//}
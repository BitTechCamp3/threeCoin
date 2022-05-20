package com.team.three.coin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://bittechcamp3.github.io/frontend" )
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .maxAge(3600);;
    }
}

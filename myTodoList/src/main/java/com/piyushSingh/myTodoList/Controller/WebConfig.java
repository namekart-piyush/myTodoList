package com.piyushSingh.myTodoList.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // If you want cookies/access-control to be sent
        config.addAllowedOriginPattern("*"); // This allows all origins
        config.addAllowedHeader("*"); // This allows all headers
        config.addAllowedMethod("*"); // This allows all methods
        source.registerCorsConfiguration("/**", config); // This applies CORS to all paths
        return new CorsFilter(source);
    }
}

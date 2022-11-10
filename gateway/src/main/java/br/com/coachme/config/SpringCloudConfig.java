package br.com.coachme.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/send-email")
                        .uri("lb://EMAILSENDER"))
                .route(r -> r.path("/v1/user/**")
                        .uri("lb://USER"))
                .route(r -> r.path("/v1/disponibility/**")
                        .uri("lb://MENTORSHIP"))
                .route(r -> r.path("/v1/mentorship/**")
                        .uri("lb://MENTORSHIP"))
                .route(r -> r.path("/v1/request/**")
                        .uri("lb://MENTORSHIP"))
                .route(r -> r.path("/v1/rating/**")
                        .uri("lb://MENTORSHIP"))
                .build();

    }

}
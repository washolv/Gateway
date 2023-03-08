package com.ada.api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    public RouteLocator customRouterLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("livros-service", route ->
                        route.path("/livros-service/**").filters(filter -> filter.rewritePath(
                                "/livros-service/(?<remaining>.*)", "/${remaining}"))
                                .uri("http://localhost:8080")).build();
    }
}

package com.crazycoder.crazyharborapigateway.config;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {


    private final GatewayFilter apiVersionCheckFilter;

    public RouteConfig(GatewayFilter apiVersionCheckFilter) {
        this.apiVersionCheckFilter = apiVersionCheckFilter;

    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                // localhost:8765/crazy-harbor-bff/health/v1/database -> localhost:8080//health/v1/database
                .route("crazy-harbor-bff", r -> r.path("/crazy-harbor-bff/**")
                        .filters(f -> f.rewritePath(
                                                "/crazy-harbor-bff/(?<path>.*)", "/${path}"
                                        )
                                        .filters(apiVersionCheckFilter)
                                //   .addResponseHeader("X-Powered-By", "Cengizhan Gateway Service")
                        )
                        .uri("lb://crazy-harbor-bff"))
                .route("crazy-harbor-consumer", r -> r.path("/crazy-harbor-consumer/**")
                        .filters(f -> f.rewritePath(
                                                "/crazy-harbor-consumer/(?<path>.*)", "/${path}"
                                        )
                                        .filters(apiVersionCheckFilter)
                                //   .addResponseHeader("X-Powered-By", "Cengizhan Gateway Service")
                        )
                        .uri("lb://crazy-harbor-consumer"))

                .build();
    }


}

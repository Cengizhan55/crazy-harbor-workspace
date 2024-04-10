package com.crazycoder.crazyharborapigateway.filter;


import com.crazycoder.crazyharborapigateway.constant.FilterOrderConstant;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ApiVersionCheckFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // checks if the url path has containts v1 otherwise throws an exception
        if(!exchange.getRequest().getURI().getPath().contains("v1")){
            throw new RuntimeException();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return FilterOrderConstant.API_VERSION_CHECK;
    }
}

package com.crazycoder.crazyharborbff.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class EndpointCheckFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (Objects.nonNull(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            log.info("Requested URI : {}", request.getRequestURI());
        }
        throw new ServletException("Empty getRequestUri , so exception thrown.");
    }
}

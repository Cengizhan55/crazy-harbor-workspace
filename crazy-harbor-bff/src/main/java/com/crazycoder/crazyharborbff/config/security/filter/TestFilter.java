package com.crazycoder.crazyharborbff.config.security.filter;

import com.crazycoder.crazyharborbff.config.security.authentication.TestAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
/*
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

 */
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TestFilter  {
    /*

    private final AuthenticationManager authManager;

    public TestFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String password = request.getHeader("x-harbor-header");
        TestAuthentication authRequest = TestAuthentication.unauthenticated(password);
        try {
            var authentication = authManager.authenticate(authRequest);

            var newContext = SecurityContextHolder.createEmptyContext();
            newContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(newContext);

            filterChain.doFilter(request, response);
            return;


        } catch (AuthenticationException e) {
            logger.info("auth error");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/plain;charset=utf-8");
            response.getWriter().println("You are not harbor ui");
            return;

        }


    }

     */
}

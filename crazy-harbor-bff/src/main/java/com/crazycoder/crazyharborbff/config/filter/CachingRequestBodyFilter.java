package com.crazycoder.crazyharborbff.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
@Slf4j
public class CachingRequestBodyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            ContentCachingRequestWrapper contentCachingRequestWrapper = wrapRequest(request);
            ContentCachingResponseWrapper contentCachingResponseWrapper = wrapResponse(response);

            doFilterWrapped(contentCachingRequestWrapper, contentCachingResponseWrapper, filterChain);
            contentCachingResponseWrapper.copyBodyToResponse();
        }
    }

    private void doFilterWrapped(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }

    private ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper requestWrapper) {
            return requestWrapper;
        } else {
            return new ContentCachingResponseWrapper(response);
        }
    }

    private ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {

        if (request instanceof ContentCachingRequestWrapper requestWrapper) {
            return requestWrapper;
        } else {
            return new ContentCachingRequestWrapper(request);
        }
    }
}

package com.crazycoder.crazyharborbff.config.interceptor;


import com.crazycoder.crazyharborbff.controller.common.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomGloabalRequestInterceptor implements HandlerInterceptor {

    private final ObjectMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            MDC.clear();

            if (handler instanceof HandlerMethod handlerMethod && (check(handlerMethod))) {

                String traceId = request.getHeader("x-trace-id");
                String clientId = request.getHeader("x-client-id");

                if (StringUtils.isEmpty(traceId)) {
                    traceId = UUID.randomUUID().toString();
                }

                MDC.put("traceId", traceId);
                MDC.put("clientNo", clientId);

                response.setHeader("x-trace-id", traceId);

                final ContentCachingRequestWrapper requestWrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);

                logReqeustHeader(requestWrapper);
            }

        } catch (Exception e) {
            log.error("preHandle error", e);
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        final ContentCachingRequestWrapper requestWrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);

        final ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);

        try {
            if (handler instanceof HandlerMethod handlerMethod && (check(handlerMethod))) {
                logRequestContent(requestWrapper);
                logResponse(responseWrapper);
            }
        } catch (Exception e) {
            log.error("afterCompletion Error: ", e);
        } finally {
            try {
                if (Objects.nonNull(responseWrapper)) {
                    responseWrapper.copyBodyToResponse();
                }
            } catch (Exception e) {
                //ignore
            }

            MDC.clear();
        }
    }

    private void logResponse(ContentCachingResponseWrapper response) {
        int status = response.getStatus();
        log.info("Response Info: Status: {} {}", status, HttpStatus.valueOf(status).getReasonPhrase());

        byte[] content = response.getContentAsByteArray();

        if (content.length > 0) {
            logContent(content, response.getContentType(), response.getCharacterEncoding(), "Response");
        }
    }

    private void logRequestContent(ContentCachingRequestWrapper request) {

        byte[] content = request.getContentAsByteArray();

        if (content.length > 0) {
            logContent(content, request.getContentType(), request.getCharacterEncoding(), "Request");
        }

    }

    private void logContent(byte[] content, String contentType, String contentEncoding, String prefix) {

        MediaType mediaType = MediaType.valueOf(contentType);
        boolean visible = VISIBLE_TYPES.stream().anyMatch(type -> type.includes(mediaType));

        if (visible) {

            try {
                String body = toPrettyString(content);

                if (StringUtils.isEmpty(body)) {
                    body = new String(content, contentEncoding);
                }
                log.info("{} Body: {}", prefix, body);
            } catch (Exception e) {
                log.info("{} Body: [{} bytes content] Error: {}", prefix, content.length, e.getMessage());
            }

        } else {
            log.info("{} Body: [{} bytes content]", prefix, content.length);
        }


    }

    private String toPrettyString(byte[] content) {

        String response = "";

        try {
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readTree(content));
        } catch (Exception e) {

            log.error("Json toPrettyString error -> {} ", e.getMessage());
        }

        return response;
    }


    private boolean check(HandlerMethod handler) {
        if (handler.getMethod().getDeclaringClass().getInterfaces().length > 0) {
            return BaseController.class.equals(handler.getMethod().getDeclaringClass().getInterfaces()[0]);
        }
        return false;
    }

    private void logReqeustHeader(ContentCachingRequestWrapper request) {

        String queryString = request.getQueryString();

        if (queryString == null) {
            log.info("Request Info: {} {}", request.getMethod(), request.getRequestURI());
        } else {
            log.info("Request Info: {} {}?{}", request.getMethod(), request.getRequestURI(), queryString);
        }
    }

    public static final List<MediaType> VISIBLE_TYPES = Arrays.asList(
            MediaType.valueOf("text/*"),
            MediaType.valueOf("application/*+json"),
            MediaType.APPLICATION_JSON,
            MediaType.MULTIPART_FORM_DATA,
            MediaType.APPLICATION_FORM_URLENCODED
    );


}

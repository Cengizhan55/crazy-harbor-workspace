package com.crazycoder.crazyharborbff.config.security.interceptor;

import com.crazycoder.crazyharborbff.config.interceptor.CustomGloabalRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegistry implements WebMvcConfigurer {

    private final CustomGloabalRequestInterceptor customGloabalRequestInterceptor;

    public InterceptorRegistry(CustomGloabalRequestInterceptor customGloabalRequestInterceptor) {
        this.customGloabalRequestInterceptor = customGloabalRequestInterceptor;

    }

    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(customGloabalRequestInterceptor);
    }
}

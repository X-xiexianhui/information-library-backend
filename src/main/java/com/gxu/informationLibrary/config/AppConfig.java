package com.gxu.informationLibrary.config;

import org.jetbrains.annotations.NotNull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public CookieAndSessionInterceptor interceptor(){
        return new CookieAndSessionInterceptor();
    }
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(interceptor()).excludePathPatterns();
    }
}

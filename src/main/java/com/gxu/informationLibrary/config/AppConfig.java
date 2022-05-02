package com.gxu.informationLibrary.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public CookieAndSessionInterceptor interceptor() {
        return new CookieAndSessionInterceptor();
    }

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        List<String> pattern = Arrays.asList(
                "/", "css/**", "js/**", "img/**", "json/**", "fonts/**", "/*.html",
                "/api/user/login", "/api/user/logout", "/api/pwd/reset", "/api/user/check","/api/email/check");
        registry.addInterceptor(interceptor()).excludePathPatterns(pattern);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**");
    }
}

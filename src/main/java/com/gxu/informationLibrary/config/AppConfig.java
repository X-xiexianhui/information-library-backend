package com.gxu.informationLibrary.config;

import org.jetbrains.annotations.NotNull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public CookieAndSessionInterceptor interceptor(){
        return new CookieAndSessionInterceptor();
    }
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        List<String>pattern= Arrays.asList("/", "css/**", "js/**", "img/**", "json/**", "fonts/**","/*.html");
        pattern.add("api/user/login");
        pattern.add("api/user/logout");
        pattern.add("api/pwd/reset");
        registry.addInterceptor(interceptor()).excludePathPatterns();
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**");
    }
}

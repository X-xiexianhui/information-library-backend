package com.gxu.informationLibrary.config;

import org.jetbrains.annotations.NotNull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
//    @Bean
//    public CookieAndSessionInterceptor interceptor(){
//        return new CookieAndSessionInterceptor();
//    }
//    @Override
//    public void addInterceptors(@NotNull InterceptorRegistry registry) {
//        List<String>pattern=new ArrayList<>();
//        pattern.add("api/user/login");
//        pattern.add("api/user/logout");
//        pattern.add("api/pwd/reset");
//        registry.addInterceptor(interceptor()).excludePathPatterns();
//    }
}

package com.semi_semi_backend11.semisemi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private BlockPathInterceptor blockPathInterceptor;

    // 인터셉터 추가 (특정 페이지 접근 금지)
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(blockPathInterceptor)
                .addPathPatterns("/**");
    }

    // 정적 파일 처리 (예: /images, /css 등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")  // 정적 파일 경로
                .addResourceLocations("file:images/");  // 실제 파일 위치
    }

}

package com.rapaul.shopping_mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rapaul.shopping_mall.interceptor.JwtInterceptor;
import com.rapaul.shopping_mall.interceptor.ParameterEscapeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
	 @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
        	.addPathPatterns("/api/**")
        	.excludePathPatterns("/api/users/login", "/api/users/register", "/api/members/login", "/api/members/register");
        registry.addInterceptor(new ParameterEscapeInterceptor());
	}
}

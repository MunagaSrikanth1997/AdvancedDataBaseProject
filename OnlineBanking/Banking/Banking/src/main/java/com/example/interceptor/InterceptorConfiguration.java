package com.example.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	   
//	    public void addInterceptors(InterceptorConfiguration registry) {
//	        registry.addInterceptors(new AuditLogInterceptor())
//	                .addPathPatterns("/**"); // Apply interceptor to all requests
//	    }
}

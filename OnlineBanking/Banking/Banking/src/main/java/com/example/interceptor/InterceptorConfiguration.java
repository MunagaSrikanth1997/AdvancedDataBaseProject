//package com.example.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//public class InterceptorConfiguration implements WebMvcConfigurer{
//	   
//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuditLogInterceptor())
//                .addPathPatterns("/**") // Apply to all paths
//                .excludePathPatterns("/public/**"); // Exclude specific paths
//    }
//}

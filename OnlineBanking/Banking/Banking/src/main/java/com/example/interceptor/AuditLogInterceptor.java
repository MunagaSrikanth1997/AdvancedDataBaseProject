//package com.example.interceptor;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//@Order(2)
//public class AuditLogInterceptor implements HandlerInterceptor {
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("Pre-handle method is called");
//		 String uri = request.getRequestURI();
//	        System.out.println("Request URI: " + uri);
//
//	        // Get the request method
//	        String method = request.getMethod();
//	        System.out.println("Request Method: " + method);
//		// You can perform pre-processing tasks here
//		// For example, authentication, logging, etc.
//	        if (request instanceof ContentCachingRequestWrapper) {
//	            ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
//
//	            // Get the captured request body
//	            byte[] requestBody = requestWrapper.getContentAsByteArray();
//	            String requestBodyString = new String(requestBody);
//
//	            // Log or process the captured request body
//	            System.out.println("Captured Request Body: " + requestBodyString);
//	        }
//		// Returning true allows the handler method to be executed; returning false
//		// stops it
//		return true;
//	}
//
//	// This method is called after the handler method is called, but before the view
//	// is rendered
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("Post-handle method is called");
//		System.out.println(response.getStatus());
//		System.out.println(response.getContentType());
//
//		if (response instanceof ContentCachingResponseWrapper) {
//            ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;
//
//            // Get the captured response body
//            byte[] responseBody = responseWrapper.getContentAsByteArray();
//            String responseBodyString = new String(responseBody);
//
//            // Log or process the captured response body
//            System.out.println("Captured Response Body: " + responseBodyString);
//        }
//		// You can perform post-processing tasks here
//		// For example, modifying the modelAndView, logging, etc.
//	}
//
//	// This method is called after the view is rendered
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		System.out.println("After-completion method is called");
//
//		// You can perform tasks after the completion of the request, such as logging,
//		// cleanup, etc.
//	}
//
//}


package com.example.interceptor;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.example.sqs.SQSConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebFilter("/*")
@Order(1)
public class RequestResponseCaptureFilter extends OncePerRequestFilter {

	private static final Logger logger = Logger.getLogger(RequestResponseCaptureFilter.class.getName());
	@Autowired
	SQSConfig sQSConfig;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		try {
			// Call the next filter in the chain
			filterChain.doFilter(requestWrapper, responseWrapper);
		} finally {
			// Capture and log the request body
			byte[] requestBody = requestWrapper.getContentAsByteArray();
			String requestBodyString = new String(requestBody);
			logger.info("Captured Request Body: " + requestBodyString);

			// Capture and log the response body
			byte[] responseBody = responseWrapper.getContentAsByteArray();
			String responseBodyString = new String(responseBody);
			logger.info("Captured Response Body: " + responseBodyString);
			String data=StringUtils.isEmpty(requestBodyString) && StringUtils.isEmpty(responseBodyString)?"error":requestBodyString + responseBodyString;
			sQSConfig.getSqsClient()
					.sendMessage(builder -> builder.queueUrl(sQSConfig.getSQSQueueUrlByQueueName("OnlineBankingAudit"))
							.messageBody(data));
			// Write the response body to the original response
			responseWrapper.copyBodyToResponse();
		}
	}
}

package com.manulife.analytics.exception.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class AnalyticsExceptionMappingResolver extends
		SimpleMappingExceptionResolver {

	@Override
	public String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}

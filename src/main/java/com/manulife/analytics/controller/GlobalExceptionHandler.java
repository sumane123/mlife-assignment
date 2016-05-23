package com.manulife.analytics.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.manulife.analytics.exception.AnalyticsException;
import com.manulife.analytics.model.ExceptionJSONInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) {
		logger.info("SQLException Occured:: URL=" + request.getRequestURL());
		return "database_error";
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested resource not found")
	@ExceptionHandler(IOException.class)
	public @ResponseBody ExceptionJSONInfo handleIOException(
			HttpServletRequest request, Exception ex) {

		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setErrorCode("404");

		return response;
	}

	@ExceptionHandler(AnalyticsException.class)
	public @ResponseBody ExceptionJSONInfo handleAnalyticsException(
			HttpServletRequest request, Exception ex) {

		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setErrorCode("400");
		System.out.println("Response error is " + response);
		return response;
	}
}

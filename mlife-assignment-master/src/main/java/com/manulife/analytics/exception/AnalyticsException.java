package com.manulife.analytics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="BAD REQUEST") //404
public class AnalyticsException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public AnalyticsException(String message){
		super("AnalyticsException with message ="+message);
		
	}
	
}

package com.manulife.analytics.utils;

public class AnalyticsConstant {
	
	public static final int SERVICE_PORT = 21;
	
	public static final String URI_GET_WEBSITE_LIST = "/rest/v1/websites";
	
	public static final String QUERY_LIST_WEBSITES_BY_DATE = "SELECT date, website, visits FROM web_analytics WHERE date= ? "
				+ "ORDER BY visits DESC LIMIT ?";
	
	public static final int DEFAULT_RECORD_LIMIT = 5 ;

	public static final String WEBSITE_NAME = "website";
	
	public static final String WEBSITE_VISITS = "visits";
	
	public static final String REQUEST_PARAM_DATE = "date";
	
	public static final String REQUEST_PARAM_LIMIT = "limit";
	
}

package com.manulife.analytics.model;

import java.util.HashMap;
import java.util.List;

public class WebsiteAnalytics {
	
	public HashMap<String, List<Website>> getAnalyticsMap() {
		return analyticsMap;
	}

	public void setAnalyticsMap(HashMap<String, List<Website>> analyticsMap) {
		this.analyticsMap = analyticsMap;
	}

	private HashMap<String, List<Website>> analyticsMap;

	

}

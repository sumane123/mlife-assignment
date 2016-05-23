package com.manulife.analytics.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manulife.analytics.dao.IAnalyticsDAO;
import com.manulife.analytics.model.Website;

/**
 * This implementation class is responsible for delegating a request to Data
 * Access Object (DAO) class to to retrieve the list of top Websites on a single
 * day
 * 
 * @author Suman Deb Roy
 */
public class WebAnalyticsServiceImpl implements IAnalyticsService {

	@Autowired
	IAnalyticsDAO analyticsDAO;

	/**
	 * /**
	 * 
	 * This method will be called from a controller class to get the list of top
	 * Websites on a single day from the mySQL database using Spring JDBC
	 * template Object.
	 * 
	 * 
	 * @param date
	 *            - User chooses date in the UI
	 * @param limit
	 *            - User preferences to display top # of Websites on a given
	 *            date. Default is 5
	 * @return JSON Object
	 */
	@Override
	public HashMap<String, List<Website>> getTopWebsitesByDate(String date,
			int limit) {

		return analyticsDAO.getTopWebsitesByDate(date, limit);

	}

}

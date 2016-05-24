package com.manulife.analytics.dao;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import com.manulife.analytics.model.Website;
import com.manulife.analytics.model.WebsiteAnalytics;

/**
 * This Interface is responsible for Qeuering the MySQL database using
 * JdbcTemplate to retrieve the list of top Websites on a single day
 * 
 * @author Suman Deb Roy
 */
public interface IAnalyticsDAO {

	/**
	 * /**
	 * 
	 * This method will be called from a controller class to get the list of top
	 * Websites on a single day from the mySQL database using Spring JDBC template Object.
	 * 
	 * 
	 * @param date
	 *            - User chooses date in the UI
	 * @param limit
	 *            - User preferences to display top # of Websites on a given
	 *            date. Default is 5
	 * @return JSON Object
	 */

	public HashMap<String, List<Website>> getTopWebsitesByDate(String date,
			int limit);

}

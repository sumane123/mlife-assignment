package com.manulife.analytics.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.manulife.analytics.model.Website;
import com.manulife.analytics.utils.AnalyticsConstant;

/**
 * This implementation class is responsible for Qeuering the MySQL database
 * using JdbcTemplate to retrieve the list of top Websites on a single day
 * 
 * @author Suman Deb Roy
 */
public class WebAnalyticsDAOImpl implements IAnalyticsDAO {

	/*
	 * Logger Service
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(WebAnalyticsDAOImpl.class);

	/*
	 * Spring JdbcTemplate utility class is used here to avoid bolier-plate code
	 * from our database operations logic such as Opening/Closing Connection,
	 * ResultSet, PreparedStatement etc.
	 */
	private JdbcTemplate jdbcTemplate;

	// setJdbcTemplate setter to make it ready for use
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
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

	@SuppressWarnings("null")
	@Override
	public HashMap<String, List<Website>> getTopWebsitesByDate(String strDate,
			int limit) {

		logger.info("START -  getTopWebsitesByDate. - argements - date = "
				+ strDate + " Max Records - " + limit);

		if (strDate == null || strDate.isEmpty()) {

			logger.info("getTopWebsitesByDate:  Date isn't provided by the user - return error code 200 ");

		}
		if (limit == 0) {

			logger.info("START - getTopWebsitesByDate : upper limit isn't provided by the user - "
					+ "system will set the default limit as 5 ");

			// Setting the default RECORD to 5
			limit = AnalyticsConstant.DEFAULT_RECORD_LIMIT;

			logger.info("END - getTopWebsitesByDate : upper limit isn't provided by the user - "
					+ "system will set the default limit as 5 ");
		}

		List<Website> websiteList = new ArrayList<Website>();
		// JDBC Code - Start
		String query = AnalyticsConstant.QUERY_LIST_WEBSITES_BY_DATE;
		logger.info("getTopWebsitesByDate : Query to retrieve top website list is : "
				+ query);

		// Using JDBC template to query the DB.
		List<Map<String, Object>> results = jdbcTemplate.queryForList(query,
				strDate, limit);
		logger.debug(" getTopWebsitesByDate : After successful execution of Query - Result is : "
				+ results);

		/*
		 * Hash map to store the data structure. Key is "date" which is choosen
		 * by the user and value is array of website(s) with their respective #
		 * of hits. This data structure can be extended to accommodate websites
		 * and the hits for a given date range.
		 */
		HashMap<String, List<Website>> analyticsMap = new HashMap<String, List<Website>>();

		if (results != null || results.size() != 0) {
			for (Map<String, Object> result : results) {
				Website website = new Website();

				website.setName(String.valueOf(result
						.get(AnalyticsConstant.WEBSITE_NAME)));
				website.setVisits(BigInteger.valueOf((Long) result
						.get(AnalyticsConstant.WEBSITE_VISITS)));
				websiteList.add(website);
			}
		}
		analyticsMap.put(strDate, websiteList);
		logger.debug(" END  - getTopWebsitesByDate" + results);
		return analyticsMap;

	}
}

package com.manulife.analytics.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manulife.analytics.exception.AnalyticsException;
import com.manulife.analytics.model.ExceptionJSONInfo;
import com.manulife.analytics.model.Website;
import com.manulife.analytics.service.IAnalyticsService;
import com.manulife.analytics.utils.AnalyticsConstant;

/**
 * This Spring MVC controller class is responsible to get top website data by a
 * given date. It calls various Service/DAO to get the data which is stored in
 * MySQL database.
 * 
 * @author Suman Deb Roy
 */
@Controller
public class AnalyticsController {

	private static final Logger logger = LoggerFactory
			.getLogger(AnalyticsController.class);

	@Autowired
	IAnalyticsService analyticsService;

	/**
	 * This is the default URL which would redirect the user to the SPA shell
	 * page.
	 * 
	 * @return index.html - Shell page of the demo application.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect() {

		logger.debug("Inside redirect method : which will redirect to shell page - index.html");

		return "redirect:/resources/index.html";
	}

	/**
	 * 
	 * This method will be called when the user invokes the URL "/rest/website".
	 * This method will call respective service method to retrieve the list of
	 * top Websites on a single day.
	 * 
	 * 
	 * @param date
	 *            - User chooses date in the UI
	 * @param limit
	 *            - User preferences to display top # of Websites on a given
	 *            date. Default is 5
	 * @return ResponseBody to return JSON Array/Object
	 * @throws AnalyticsException
	 */

	@RequestMapping(value = AnalyticsConstant.URI_GET_WEBSITE_LIST, method = RequestMethod.GET)
	public @ResponseBody HashMap<String, List<Website>> getTopWebsitesByDate(
			@RequestParam(AnalyticsConstant.REQUEST_PARAM_DATE) String date,
			@RequestParam(AnalyticsConstant.REQUEST_PARAM_LIMIT) String limit)
			throws Exception {

		if (date.isEmpty() || limit.isEmpty()) {

			throw new AnalyticsException("Input contains null or empty values");

		}

		HashMap<String, List<Website>> analyticsMap = analyticsService
				.getTopWebsitesByDate(date, Integer.parseInt(limit));

		return analyticsMap;

	}

}

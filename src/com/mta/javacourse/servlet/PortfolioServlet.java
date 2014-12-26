package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;

/**
 * @author Irena Yakobovich
 * date 10th of December 2014
 */
@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet  {	
	/**
	 * Request and Response from the user in HTML
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		
		resp.getWriter().println(portfolio.getHtmlString());
		
		resp.setContentType("text/html");
	}	
}
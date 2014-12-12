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
		Stock[] stocks = portfolio.getStocks();	
		portfolio.setTitle("Portfolio #1");

		/** 
		 * Creating another portfolio, which is a copy of the previous one.
		 */
		Portfolio portfolioCopy = new Portfolio(portfolio);
		portfolioCopy.setTitle("Portfolio #2");

		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolioCopy.getHtmlString());

		/**
		 * Removing the first stock from the first portfolio.
		 */
		portfolio.removeFirstStock(portfolio);

		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolioCopy.getHtmlString());

		/**
		 * Changing the bid value in the third stock of the copy portfolio.
		 */
		portfolioCopy.getStocks()[2].setBid(55.55f);

		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolioCopy.getHtmlString());

		resp.setContentType("text/html");
	}	
}
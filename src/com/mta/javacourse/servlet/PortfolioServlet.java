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
public class PortfolioServlet extends HttpServlet { 
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStocks();

		Portfolio portfolioCopy = new Portfolio();
		portfolioCopy.setTitle("Portfolio #2");

		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolioCopy.getHtmlString());

	}
}
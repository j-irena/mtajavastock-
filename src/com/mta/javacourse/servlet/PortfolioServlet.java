package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.InvalidQuantityException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;

/**
 * @author Irena Yakobovich
 * date 10th of December 2014
 */
@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet  {	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		try {
			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlString());
			
		} catch(PortfolioFullException e) {
			resp.getWriter().println("Portfolio is full!");
		} catch(StockAlreadyExistsException e) {
			resp.getWriter().println("The stock already exists!");
		} catch (BalanceException e) {
			resp.getWriter().println("Not enough balance!");
		} catch (StockNotExistException e) {
			resp.getWriter().println("The stock does not exist!");
		} catch (InvalidQuantityException e) {
			resp.getWriter().println("The quantity entered is invalid!");
		}
	}	
}
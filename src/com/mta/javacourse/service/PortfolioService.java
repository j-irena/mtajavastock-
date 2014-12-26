package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

/**
 * @author Irena Yakobovich
 * date 3rd of December 2014
 *
 */
public class PortfolioService {

	/** 
	 * Setting the date to 15th of November 2014
	 * @return myPortfolio, that contains each added stock.
	 */
	public Portfolio getPortfolio() {
		Portfolio myPortfolio = new Portfolio(); 
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2014, 10, 15);
		Date myDate = calendar.getTime();
		
		myPortfolio.setBalance(10000);
		myPortfolio.setTitle("Exercise 7 portfolio");
		
		/**
		 *  Setting information concerning to each stock, including symbol, ask, bid and date.
		 *  Each stock is added to myPorfolio.
		 *  myPortfolio is returned.
		 */

		Stock st1 = new Stock("PIH", (float)10, (float)8.5, myDate);
		myPortfolio.addStock(st1);

		Stock st2 = new Stock("AAL", (float)30, (float)25.5, myDate);
		myPortfolio.addStock(st2);

		Stock st3 = new Stock("CAAS", (float)20, (float)15.5, myDate);
		myPortfolio.addStock(st3);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
	}
}

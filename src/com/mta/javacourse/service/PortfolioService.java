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

		/**
		 *  Setting information concerning to each stock, including symbol, ask, bid and date.
		 *  Each stock is added to myPorfolio.
		 *  myPortfolio is returned.
		 */
		
		Stock st1 = new Stock("PIH", (float)12.4, (float)13.1, myDate);
		myPortfolio.addStock(st1);

		Stock st2 = new Stock("AAL", (float)5.5, (float)5.78, myDate);
		myPortfolio.addStock(st2);

		Stock st3 = new Stock("CAAS", (float)31.5, (float)31.2, myDate);
		myPortfolio.addStock(st3);

		return myPortfolio;
	}
}

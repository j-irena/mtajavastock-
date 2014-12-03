package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.Stock;
import com.mta.javacourse.model.Portfolio;

/**
 * @author Irena Yakobovich
 * date 3rd of December 2014
 *
 */
public class PortfolioService {

	/** 
	 * Setting the date to 15th of November 2014
	 * 
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
		Stock st1 = new Stock();
		st1.setSymbol("PIH");
		st1.setAsk((float)( 12.4));
		st1.setBid((float)(13.1));
		st1.setDate(myDate);
		myPortfolio.addStock(st1);

		Stock st2 = new Stock();
		st2.setSymbol("AAL");
		st2.setAsk((float)(5.5));
		st2.setBid((float)(5.78));
		st2.setDate(myDate);
		myPortfolio.addStock(st2);

		Stock st3 = new Stock();
		st3.setSymbol("CAAS");
		st3.setAsk((float)(31.5));
		st3.setBid((float)(31.2));
		st3.setDate(myDate);
		myPortfolio.addStock(st3);

		return myPortfolio;
	}
}

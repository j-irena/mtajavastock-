package com.mta.javacourse.service;

import com.mta.javacourse.Stock;
import com.mta.javacourse.model.Portfolio;


public class PortfolioService {

	Portfolio myPorfolio = new Portfolio(); 
	public Portfolio getPortfolio(Portfolio myPortfolio) {
		
		java.util.Date myDate = null;

		Stock st1 = new Stock();
		st1.setSymbol("PIH");
		st1.setAsk((float)( 12.4));
		st1.setBid((float)(13.1));
		st1.setDate(myDate);
		myPorfolio.addStock(st1);

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

package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.Stock;

/** Definition of stock portfolio: contains an arrays of stocks and it's status. 
 * @author Irena Yakobovich
 * date 1st of December 2014 
 */
public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize = 0;
	private String title = "Portfolio";

	/** Stock portfolio contains a max number of an array of stocks,
	 * and a max number of an array of stock status.
	 */
	public Portfolio() {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}

	/**
	 * addStock receives a stock and adds it to stocks array.
	 * Each stock increases portfolioSize by one, so that the next stock would
	 * be placed in the next location of the stock array. 
	 */
	public void addStock (Stock stock){
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}	
	/**
	 * @return the stock array.
	 */
	public Stock[] getStocks(){
		return stocks;	
	}
	/**
	 * Gathering the Stocks information into one string parameter res via loop.
	 * The loop goes on until it reaches the portfolioSize, which was defined by
	 * the number of stocks. By the time the loop ends, the res parameter is returned. 
	 * 
	 * @param res contains a string of the title and the stocks array details.
	 * @return the title and the stock array details.  
	 */
	public String getHtmlString(){
		String res = "<h1>" + title + "</h1>" + "<br>";
		for (int i = 0; i < portfolioSize; i++)
		{
			res += stocks[i].getHtmlDescription() + "<br>";
		}
		return res;
	}
	/**
	 *  Inner class that contains several details concerning a specific stock.
	 *  It would determine whether to buy, sell or do nothing with the stock, as it
	 *  takes into account the stock parameters: symbol, bid, ask, recommendation, quantity,
	 *  and its date.
	 */
	public class StockStatus {
		public final static int DO_NOTHING = 0;
		public final static int BUY = 1;
		public final static int SELL = 2;
		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
	}
}
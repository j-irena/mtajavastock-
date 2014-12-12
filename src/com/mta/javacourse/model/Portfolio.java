package com.mta.javacourse.model;

import java.util.Date;

/** Definition of stock portfolio: contains an arrays of stocks and it's status. 
 * @author Irena Yakobovich
 * date 1st of December 2014 
 */
public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize;
	private String title = "Portfolio";

	/** 
	 * Stock portfolio contains a max number of an array of stocks,
	 * and a max number of an array of stock status.
	 */
	public Portfolio() {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}
	/** 
	 * Portfolio copy c'tor
	 */
	public Portfolio (Portfolio p) { 
		this.stocks = new Stock[portfolioSize];
		this.stocksStatus = new StockStatus[portfolioSize];
		
		for(int i = 0; i < p.portfolioSize; i++) {  
			this.stocks[i] = new Stock(p.stocks[i]);    
			this.stocksStatus[i] = new StockStatus(p.stocksStatus[i]);
		}
		this.portfolioSize = p.portfolioSize;
		this.title = p.title;
	}

	/**
	 * addStock receives a stock and adds it to stocks array.
	 * Each stock increases portfolioSize by one, so that the next stock would
	 * be placed in the next location of the stock array. 
	 */
	public void addStock (Stock stock){
		if (this.portfolioSize < MAX_PORTFOLIO_SIZE){
			this.stocks[this.portfolioSize++] = stock;
		}	
	}
	public Stock[] getStocks(){
		return stocks;	
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setTitle(String title) {
		this.title = title;
	}	

	public String getTitle(){
		return title;
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

		/**
		 * StockStatus copy c'tor
		 * @param stockStatus
		 */
		public StockStatus(String s, float cb, float ca, Date d, int r, int sq){
			this.setSymbol(s);
			this.setCurrentBid(cb);
			this.setCurrentAsk(ca);
			this.setDate(d);
			this.setRecommendation(r);
			this.setStockQuantity(sq);
		}

		public StockStatus(StockStatus st){
			this(st.symbol, st.currentBid, st.currentAsk, st.date, st.recommendation, st.stockQuantity);
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public float getCurrentBid() {
			return currentBid;
		}

		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}

		public float getCurrentAsk() {
			return currentAsk;
		}

		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getRecommendation() {
			return recommendation;
		}

		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}

		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}
}

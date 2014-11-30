package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.Stock;

public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize = 0;
	
	public Portfolio() {
		Stock[] stock = new Stock[MAX_PORTFOLIO_SIZE];
	StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}
	public void addStock (Stock stock){
		stocks[portfolioSize] = stock;
				portfolioSize++;
	}	
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
package com.mta.javacourse.model;

import java.util.Date;

/**
 * Definition of a stock and it's setters and getters.
 * 
 * @author Irena Yakobovich date 25th of November 2014
 */

public class Stock {
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private String htmlDescription;

	/**
	 * Stock c'tor
	 * @param symbol
	 * @param ask
	 * @param bid
	 * @param date
	 */

	public Stock(String symbol, float ask, float bid, Date date) {
		this.setSymbol(symbol);
		this.setAsk(ask);
		this.setBid(bid);
		this.setDate(date);
	}

	/**
	 * Stock copy c'tor
	 * @param s
	 */
	public Stock(Stock s) {
		this(s.getSymbol(), s.getAsk(), s.getBid(), s.getDate());
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public float getBid() {
		return bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * A method that gathers information of the stock and returns it.
	 */
	public String getHtmlDescription() {
		htmlDescription = "<b>Stock symbol is </b>" + getSymbol()
				+ ",<b> ask: </b>" + getAsk() + ",<b> bid: </b>" + getBid()
				+ ",<b> date: </b>" + getDate();
		return htmlDescription;
	}
}
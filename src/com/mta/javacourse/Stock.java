package com.mta.javacourse;

/**Definition of a stock and it's setters and getters.
 * @author Irena Yakobovich
 * date 25th of November 2014
 */
public class Stock {
	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date date;
	private String htmlDescription;

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
		htmlDescription  = "<b>Stock symbol is </b>" + getSymbol() 
				+ ",<b> ask: </b>" + getAsk() + ",<b> bid: </b>" 
				+ getBid() + ",<b> date: </b>" + getDate();
		return htmlDescription;
	}
}
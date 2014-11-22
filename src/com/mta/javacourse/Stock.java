package com.mta.javacourse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Stock extends HttpServlet {
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
	
	public String getHtmlDescription() {
		htmlDescription  = "<b>Stock symbol is </b>" + getSymbol() + ",<b> ask: </b>" + getAsk() + ",<b> bid: </b>" + getBid() + ",<b> date: </b>" + getDate();
		return htmlDescription;
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	Stock st1 = new Stock();
	st1.setSymbol("PIH");
	st1.setAsk((float)( 12.4));
	st1.setBid((float)(13.1));
	st1.setDate(new Date());
	
	Stock st2 = new Stock();
	st2.setSymbol("AAL");
	st2.setAsk((float)(5.5));
	st2.setBid((float)(5.78));
	st2.setDate(new Date());
	
	Stock st3 = new Stock();
	st3.setSymbol("CAAS");
	st3.setAsk((float)(31.5));
	st3.setBid((float)(31.2));
	st3.setDate(new Date());
	
	resp.getWriter().println(st1.getHtmlDescription() + "<br>" + st2.getHtmlDescription() + "<br>" + st3.getHtmlDescription());
	resp.setContentType("text/html");
	}
}

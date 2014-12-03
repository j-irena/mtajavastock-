package com.mta.javacourse;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Setting the data of each stock and it's relevant date.
 * @author Irena Yakobovich
 * date 3 of December 2014
 */
@SuppressWarnings("serial")
public class StockDetails extends HttpServlet { 
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/** 
		 * Setting the date to 15th of November 2014
		 */
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2014, 10, 15);
		Date myDate = calendar.getTime();

		/**
		 *  Setting Information concerning to each stock, including symbol, ask, bid and date
		 */
		Stock st1 = new Stock();
		st1.setSymbol("PIH");
		st1.setAsk((float)( 12.4));
		st1.setBid((float)(13.1));
		st1.setDate(myDate);

		Stock st2 = new Stock();
		st2.setSymbol("AAL");
		st2.setAsk((float)(5.5));
		st2.setBid((float)(5.78));
		st2.setDate(myDate);

		Stock st3 = new Stock();
		st3.setSymbol("CAAS");
		st3.setAsk((float)(31.5));
		st3.setBid((float)(31.2));
		st3.setDate(myDate);

		/**
		 *  Printing the stocks
		 */
		resp.getWriter().println(st1.getHtmlDescription() + "<br>"
				+ st2.getHtmlDescription() + "<br>" + st3.getHtmlDescription());

		resp.setContentType("text/html");
	}
}

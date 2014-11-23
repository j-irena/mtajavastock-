package com.mta.javacourse;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		int num1;
		int num2;
		int num3;
		int radius = 50;
		double angelB = 0.523598776;
		
		// Homework #2
		num1 = 4;
		num2 = 3;
		num3 = 7;
		
		int result = (num1 + num2) * num3;
		
		String resultStr = new String("<h1>Result of " + "(" + num1 + " + " + num2 + ")" + " * " + num3 + " = " + result + "</h1>");
		resp.getWriter().println(resultStr);
		
		// Homework #3
		
		String line1 = new String("calculation 1: Area of circle with radius " + radius + " is " + Math.PI * Math.pow(radius, 2) + " square-cm." );
		String line2 = new String("calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: " + 50 * Math.sin(angelB) + " cm");
		String line3 = new String("calculation 3: Power of 20 with exp of 13 is " + Math.pow(20, 13));
		
		String resultStr2 = line1 + "<br>" + line2 + "<br>" +line3;
		resp.getWriter().println(resultStr2);
	}
}
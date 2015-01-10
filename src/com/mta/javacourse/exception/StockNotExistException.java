package com.mta.javacourse.exception;

/**
 * Exception to be thrown when a stock doesn’t exist.
 * @author Irena Yakobovich
 * @since 10th of January 2015
 */
public class StockNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public StockNotExistException(String symbol) {
		super("Stock " + symbol + " does not exist!");
	}
}

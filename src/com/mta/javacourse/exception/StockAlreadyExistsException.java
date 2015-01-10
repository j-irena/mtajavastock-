package com.mta.javacourse.exception;

/**
 * Exception to be thrown when a stock already exists.
 * @author Irena Yakobovich
 * @since 10th of January 2015
 */
public class StockAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public StockAlreadyExistsException(String symbol) {
		super("Stock " + symbol + " already exists!");
	}
}

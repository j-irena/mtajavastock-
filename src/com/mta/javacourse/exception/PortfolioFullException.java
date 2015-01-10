package com.mta.javacourse.exception;

/**
 * Exception to be thrown when adding more stocks than allowed.
 * @author Irena Yakobovich
 * @since 10th of January 2015
 */
public class PortfolioFullException extends Exception {
	private static final long serialVersionUID = 1L;

	public PortfolioFullException() {
		super("You have reached the maximum portfolio size!");
	}
}

package com.mta.javacourse.exception;

/**
 * Exception to be thrown when the portfolio balance becomes negative.
 * @author Irena Yakobovich
 * @since 10th of January 2015
 */
public class BalanceException extends Exception {
	private static final long serialVersionUID = 1L;

	public BalanceException(float balance, float ask, int quantity) {
		super("Not enough balance. Your balance is " + balance + ", whereas the amount is " + ask * quantity);
	}
}

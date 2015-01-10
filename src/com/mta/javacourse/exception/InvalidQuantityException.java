package com.mta.javacourse.exception;

/**
 * Invalid quantity entered exception.
 * @author Irena Yakobovich
 * @since 10th of January 2015
 */
public class InvalidQuantityException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidQuantityException() {
		super("The quantity entered is invalid!");
	}
}

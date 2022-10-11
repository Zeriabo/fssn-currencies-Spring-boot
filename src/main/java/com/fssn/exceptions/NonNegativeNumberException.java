package com.fssn.exceptions;

public class NonNegativeNumberException extends Exception {
	private static final long serialVersionUID = 7718828512143293558L;

	public NonNegativeNumberException(Float amount) {

		super("Can't accept negative amounts: " + amount);

	}
}

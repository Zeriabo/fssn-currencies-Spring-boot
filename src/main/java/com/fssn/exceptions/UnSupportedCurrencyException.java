package com.fssn.exceptions;

public class UnSupportedCurrencyException extends RuntimeException {

	private static final long serialVersionUID = 7718828512143293558L;

	public UnSupportedCurrencyException(String currency) {

		super("Currency: " + currency + " is not supported !");

	}

}

package com.fssn.exceptions;

public class InputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2517192017290756902L;
	private String input;

	public InputException(String input) {
		this.input = input;
	}

	public String getMessage() {

		return "Please enter a valid Social security number check :" + input;

	}
}

package com.fssn.exceptions;

public class LengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6973539928754791903L;

	private int length;
	private String testString;

	public LengthException(int length, String testString) {
		this.length = length;
		this.testString = testString;
	}

	public String getMessage() {

		return "Length of  " + testString + " should be " + length;

	}
}

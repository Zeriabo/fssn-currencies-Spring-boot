package com.fssn.models;

public class Response {

	private boolean response;
	private String message;

	public Response() {

	}

	public Response(boolean response, String message) {
		this.setResponse(response);
		this.setMessage(message);
	}

	/**
	 * @return the response
	 */
	public boolean getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(boolean response) {
		this.response = response;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}

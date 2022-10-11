package com.fssn.models;

public class Info {
	private int timestamp;
	private float quote;

	public Info() {

	}

	public Info(int timestamp, float quote) {

		this.quote = quote;
		this.timestamp = timestamp;

	}

	/**
	 * @return the timestamp
	 */
	public int getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the rate
	 */
	public float getQuote() {
		return quote;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setQuote(float quote) {
		this.quote = quote;
	}

	public String getString() {
		return "rate :" + this.quote;
	}

}

package com.fssn.payload;

public class ExchangeRateRequest {

	private String from;
	private String to;
	private float from_amount;

	public ExchangeRateRequest() {

	}

	public ExchangeRateRequest(String from, String to, float to_amount) {

		this.setFrom(from);
		this.setTo(to);
		this.setFrom_amount(to_amount);

	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the to_amount
	 */
	public float getFrom_amount() {
		return from_amount;
	}

	/**
	 * @param to_amount the to_amount to set
	 */
	public void setFrom_amount(float to_amount) {
		this.from_amount = to_amount;
	}

}

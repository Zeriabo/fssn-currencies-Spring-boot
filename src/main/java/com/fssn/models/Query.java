package com.fssn.models;

public class Query {

	private String from;
	private String to;
	private int amount;

	public Query() {

	}

	public Query(String from, String to, int amount) {
		this.amount = amount;
		this.to = to;
		this.from = from;
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getString() {
		return "from :" + this.from + " to: " + this.to + " amount" + Integer.toString(this.amount);
	}

}

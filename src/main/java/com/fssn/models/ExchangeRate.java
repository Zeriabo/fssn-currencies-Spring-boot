package com.fssn.models;

public class ExchangeRate {

	private String success;
	private Query query;
	private Info info;
	private String date;
	private float result;

	public ExchangeRate() {

	}

	public ExchangeRate(String success, Query query, Info info, String date, float result) {
		this.date = date;
		this.info = info;
		this.query = query;
		this.result = result;
		this.success = success;

	}

	/**
	 * @return the success
	 */
	public String isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * @return the query
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	/**
	 * @return the info
	 */
	public Info getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Info info) {
		this.info = info;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the result
	 */
	public float getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(float result) {
		this.result = result;
	}

	public String getExchangeRate() {
		return "At: " + this.isSuccess() + this.getDate() + " " + this.getQuery().getString() + " "
				+ this.getInfo().getString() + " " + this.getResult();
	}

	public String toString() {
		return String.format("info:%f", info.getQuote());
	}

}

package com.fssn.payload;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateResponse {
	private String from;
	private String to;
	private float to_amount;
	private float exchange_rate;
	private Date date;

	public ExchangeRateResponse() {

	}

	public ExchangeRateResponse(String from, String to, float to_amount, float exchange_rate, Date date) {
		this.setFrom(from);
		this.setTo(to);
		this.setTo_amount(to_amount);
		this.setExchange_rate(exchange_rate);
		this.setDate(date);
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
	public float getTo_amount() {
		return to_amount;
	}

	/**
	 * @param to_amount the to_amount to set
	 */
	public void setTo_amount(float to_amount) {
		this.to_amount = to_amount;
	}

	/**
	 * @return the exchange_rate
	 */
	public float getExchange_rate() {
		return exchange_rate;
	}

	/**
	 * @param exchange_rate the exchange_rate to set
	 */
	public void setExchange_rate(float exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
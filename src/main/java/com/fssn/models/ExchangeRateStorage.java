package com.fssn.models;

import java.util.Date;

public class ExchangeRateStorage {

	private float exchangeRate;
	private String currency;
	private Date date;
	private boolean used;

	public ExchangeRateStorage() {

	}

	public ExchangeRateStorage(String currency, float exchangeRate, Date date, boolean used) {
		this.exchangeRate = exchangeRate;
		this.currency = currency;
		this.date = date;
		this.used = used;
	}

	/**
	 * @return the exchangeRate
	 */

	public float getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * @return the currencies
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currencies the currencies to set
	 */
	public void setCurrency(String currencies) {
		this.currency = currencies;
	}

	/**
	 * @return the used
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * @param used the used to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}

}

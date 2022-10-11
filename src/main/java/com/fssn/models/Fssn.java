package com.fssn.models;

public class Fssn {

	private String ssn;
	private String country_code;

	public Fssn() {

	}

	public Fssn(String fssn, String countryCode) {
		this.setSsn(fssn);
		this.setCountry_code(countryCode);

	}

	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}

	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getLength() {
		return ssn.length() + country_code.length();

	}

}
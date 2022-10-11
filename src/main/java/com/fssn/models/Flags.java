package com.fssn.models;

public class Flags {

	private boolean nsfw;
	private boolean religious;
	private boolean political;
	private boolean racist;
	private boolean sexist;
	private boolean explicit;

	/**
	 * @return the nsfw
	 */
	public boolean isNsfw() {
		return nsfw;
	}

	/**
	 * @param nsfw the nsfw to set
	 */
	public void setNsfw(boolean nsfw) {
		this.nsfw = nsfw;
	}

	/**
	 * @return the religious
	 */
	public boolean isReligious() {
		return religious;
	}

	/**
	 * @param religious the religious to set
	 */
	public void setReligious(boolean religious) {
		this.religious = religious;
	}

	/**
	 * @return the political
	 */
	public boolean isPolitical() {
		return political;
	}

	/**
	 * @param political the political to set
	 */
	public void setPolitical(boolean political) {
		this.political = political;
	}

	/**
	 * @return the racist
	 */
	public boolean isRacist() {
		return racist;
	}

	/**
	 * @param racist the racist to set
	 */
	public void setRacist(boolean racist) {
		this.racist = racist;
	}

	/**
	 * @return the sexist
	 */
	public boolean isSexist() {
		return sexist;
	}

	/**
	 * @param sexist the sexist to set
	 */
	public void setSexist(boolean sexist) {
		this.sexist = sexist;
	}

	/**
	 * @return the explicit
	 */
	public boolean isExplicit() {
		return explicit;
	}

	/**
	 * @param explicit the explicit to set
	 */
	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
	}

}

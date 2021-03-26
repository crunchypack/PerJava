package com.perscholas.dev_club;

public class ClubMember {
	protected String name, city, state, lang;
	public ClubMember(String n, String c, String st, String l) {
		this.name = n;
		this.city = c;
		this.state = st;
		this.lang = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}



}

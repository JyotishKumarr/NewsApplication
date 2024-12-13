package com.NewsApp.NewsApp.models;

public class NewsSourceLang {

	private String name;
	private String description;
	private String url;
	private String country;
	private String language;
	public NewsSourceLang(String name, String description, String url, String country, String language) {
		super();
		this.name = name;
		this.description = description;
		this.url = url;
		this.country = country;
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}

package com.NewsApp.NewsApp.models;


public class NewsSourceModel {

	private String name;
	private String description;
	private String url;
	private String country;
	public NewsSourceModel(String name, String description, String url, String country) {
		super();
		this.name = name;
		this.description = description;
		this.url = url;
		this.country = country;
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
	
}

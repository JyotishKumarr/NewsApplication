package com.NewsApp.NewsApp.models;

public class NewsModel {
    private String name;
    private String description;
    private String url;
    private String author;
    private String date;
    private String imageUrl;  // New field for image URL
	public NewsModel(String name, String description, String url, String author, String date, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.url = url;
		this.author = author;
		this.date = date;
		this.imageUrl = imageUrl;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
    
    
}
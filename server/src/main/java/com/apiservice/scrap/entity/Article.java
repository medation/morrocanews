package com.apiservice.scrap.entity;


public class Article {

	private String title;
	private String body;
	private String url;
	private String urlToImage;
	
	
	public Article() {
		super();
	}


	public Article(String title, String body, String url, String urlToImage) {
		super();
		this.title = title;
		this.body = body;
		this.url = url;
		this.urlToImage = urlToImage;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUrlToImage() {
		return urlToImage;
	}


	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	
	
	
	
}

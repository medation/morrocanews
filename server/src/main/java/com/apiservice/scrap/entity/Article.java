package com.apiservice.scrap.entity;


public class Article {

	private String title;
	private String subTitle;
	private String body;
	private String url;
	private String urlToImage;
	private String datePub;

	
	
	public Article() {
		super();
	}



	public Article(String title, String subTitle, String body, String url, String urlToImage, String datePub) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.body = body;
		this.url = url;
		this.urlToImage = urlToImage;
		this.datePub = datePub;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSubTitle() {
		return subTitle;
	}



	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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



	public String getDatePub() {
		return datePub;
	}



	public void setDatePub(String datePub) {
		this.datePub = datePub;
	}

	
	
	
	
}

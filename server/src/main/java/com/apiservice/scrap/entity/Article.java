package com.apiservice.scrap.entity;

import java.util.List;

public class Article {

	private String title;
	private String subTitle;
	private String body;
	private List<String> paragraphs;
	private String url;
	private String urlToImage;
	private String datePub;
	private String iframe;
	
	
	public Article() {
		super();
	}




	public Article(String title, String subTitle, String body, List<String> paragraphs, String url, String urlToImage,
			String datePub) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.body = body;
		this.paragraphs = paragraphs;
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




	public List<String> getParagraphs() {
		return paragraphs;
	}




	public void setParagraphs(List<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	
	
	
	
}

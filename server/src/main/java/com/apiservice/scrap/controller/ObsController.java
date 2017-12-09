package com.apiservice.scrap.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.apiservice.scrap.entity.Article;

@RestController
public class ObsController {

	@RequestMapping(value = "/observateur/{type}", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	public ResponseEntity<List<Article>> listAllArticle(@PathVariable String type) throws IOException {
        
		List<Article> articles = new ArrayList<Article>();

		
		String baseUrl = "https://lobservateur.info/category/";
				
		Connection connection = Jsoup.connect(baseUrl+type);
		connection.timeout(12000);
		Document doc = connection.get();
		
		Elements divArticles = doc.select("div.post-csl");
		
		for(Element divArticle : divArticles)
		{
			Article article = new Article();
			

			Element title = divArticle.select("div.infos a.title").first();
			
			article.setTitle(title.text());			

			Element datepublication = divArticle.select("div.infos div.details span").first();
			
			article.setDatePub(datepublication.text());
			
			Element url = divArticle.select("a.image").first();
					
			article.setUrl(url.attr("href"));
			
			Element urlToImage = divArticle.select("a.image img").first();
			
			article.setUrlToImage(urlToImage.absUrl("src"));
			
			articles.add(article);
			

		}

		if(articles.isEmpty()){
            return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
        
    }
}

package com.apiservice.scrap.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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

import com.apiservice.scrap.entity.Article;

@RestController
public class ScrapController {

	@RequestMapping(value = "/telquel/{type}", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	public ResponseEntity<List<Article>> listAllArticle(@PathVariable String type) throws IOException {
        
		List<Article> articles = new ArrayList<Article>();

		
		String baseUrl = "http://telquel.ma/categorie/";
				
		Connection connection = Jsoup.connect(baseUrl+type);
		connection.timeout(12000);
		Document doc = connection.get();
		
		Elements divArticles = doc.select("div.article-big-block");
		
		for(Element divArticle : divArticles)
		{
			Article article = new Article();
			

			Element title = divArticle.select("div.article-header h2 a").first();
			
			article.setTitle(title.text());
			
			Element body = divArticle.select("div.article-content p").first();
						
			article.setBody(body.text());			

			Element url = divArticle.select("div.article-photo span a").first();
					
			article.setUrl(url.attr("href"));
			
			Element urlToImage = divArticle.select("div.article-photo span a img").first();
			
			article.setUrlToImage(urlToImage.absUrl("src"));
			
			articles.add(article);
			

		}

		if(articles.isEmpty()){
            return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
        
    }
	
}

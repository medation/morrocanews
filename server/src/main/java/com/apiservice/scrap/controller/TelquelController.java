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
public class TelquelController {

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

	
	@RequestMapping(value = "/telquelArticle/**", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	public ResponseEntity<Article> readArticle(HttpServletRequest request) throws IOException {
        
		Article article = new Article();
		
		String req = (String) request.getAttribute( HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE );
		String url = req.substring(22);
				
		Connection connection = Jsoup.connect("http://"+url);
		connection.timeout(12000);
		Document doc = connection.get();
		
		Element divArticle = doc.select("div.shortcode-content").first();
		
		Element subTitle = divArticle.select("h2").first();
		
		article.setSubTitle(subTitle.text());
		
		Elements contentArticle = divArticle.select("p");
		
		List<String> paragraphs = new ArrayList<String>();
		
		for(Element paragraph : contentArticle)
		{
			paragraphs.add(paragraph.text());
		}
		
		article.setParagraphs(paragraphs);
		
		if(article.equals(null)){
            return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
        return new ResponseEntity<Article>(article, HttpStatus.OK);
		
		
        
    }
	
}

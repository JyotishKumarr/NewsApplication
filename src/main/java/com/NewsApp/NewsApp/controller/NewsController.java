package com.NewsApp.NewsApp.controller;

import java.util.ArrayList;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.NewsApp.NewsApp.models.NewsModel;
import com.NewsApp.NewsApp.models.NewsSourceLang;
import com.NewsApp.NewsApp.models.NewsSourceModel;

@Controller
@RequestMapping("/api/news")
public class NewsController {
	
	@GetMapping("/")
	public String getMain() {
		return "Main";
	}

    @Value("${api.key}")
    private String apiKey; // Inject the API key from application.properties


    @GetMapping("/headlines")
    public String getNewsHeadlines(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + apiKey;

        // Fetch the data from the API
        String response = restTemplate.getForObject(url, String.class);

        if (response == null || response.isEmpty()) {
            model.addAttribute("error", "Failed to fetch news data.");
            return "error"; // Show error if no data is returned
        }

        // Parse the response JSON
        JSONObject jsonResponse = new JSONObject(response);

        // Check if the "articles" key exists in the response
        if (!jsonResponse.has("articles")) {
            model.addAttribute("error", "No articles found in the response.");
            return "error"; // Show error if "articles" is missing
        }

        // Get the articles array from the JSON response
        JSONArray articles = jsonResponse.getJSONArray("articles");

        // Create a list to store the news articles
        List<NewsModel> newsList = new ArrayList<>();

        // Iterate over the articles and extract the required data
        for (int i = 0; i < articles.length(); i++) {
            JSONObject article = articles.getJSONObject(i);

            // Extract data for each article
            
            String name = article.optJSONObject("source").optString("name", "News");
            String description = article.optString("description", "No Description");
            String urlArticle = article.optString("url", "#"); // Provide default URL if missing
            String author = article.optString("author", "Unknown");
            String date = article.optString("publishedAt", "No Date");
            String imageUrl = article.optString("urlToImage", "");  // Extract image URL (empty if not available)

            // Create a NewsModel object for each article
            NewsModel news = new NewsModel(name, description, urlArticle, author, date, imageUrl);

            // Add the article to the news list
            newsList.add(news);
        }

        // Add the news list to the model
        model.addAttribute("newsList", newsList);

        // Return the view name (Thymeleaf template)
        return "News";  // Ensure you have a "news.html" template in resources/templates
    }
    
    @GetMapping("headlines/sources")
    public String getNewsByCountry(Model model) {
    	//String url = "https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+apiKey;
    	
    	
    	String url = "https://newsapi.org/v2/sources?apiKey="+apiKey;
    	RestTemplate restTemplate = new RestTemplate();

        // Fetch the data from the API
        String response = restTemplate.getForObject(url, String.class);
        if (response == null || response.isEmpty()) {
            model.addAttribute("error", "Failed to fetch news data.");
            return "error"; // Show error if no data is returned
        }

        // Parse the response JSON
        JSONObject jsonResponse = new JSONObject(response);

        // Check if the "sources" key exists in the response
        if (!jsonResponse.has("sources")) {
            model.addAttribute("error", "No articles found in the response.");
            return "error"; // Show error if "sources" is missing
        }
     // Get the articles array from the JSON response
        JSONArray sources = jsonResponse.getJSONArray("sources");

        // Create a list to store the news articles
        List<NewsSourceModel> newsSourceList = new ArrayList<>();

        // Iterate over the articles and extract the required data
        for (int i = 0; i < sources.length(); i++) {
            JSONObject article = sources.getJSONObject(i);

            // Extract data for each article
            String name = article.optString("name", "No Title");
            String description = article.optString("description", "No Description");
            String urlArticle = article.optString("url", "#"); // Provide default URL if missing
            String country = article.optString("country", "Unknown");
            

            // Create a NewsModel object for each article
            NewsSourceModel news = new NewsSourceModel(name,description,urlArticle,country);

            // Add the article to the news list
            newsSourceList.add(news);
        }

        // Add the news list to the model
        model.addAttribute("newsSourceList", newsSourceList);
        
        return "NewsSource";

    }
    @GetMapping("headlines/sources/{language}")
    public String getNewsByLanguage(@PathVariable("language") String language, Model model) {
    	
        String url = "https://newsapi.org/v2/sources?language="+language+"&apiKey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        // Fetch the data from the API
        String response = restTemplate.getForObject(url, String.class);
        if (response == null || response.isEmpty()) {
            model.addAttribute("error", "Failed to fetch news data.");
            return "error"; // Show error if no data is returned
        }

        // Parse the response JSON
        JSONObject jsonResponse = new JSONObject(response);

        // Check if the "sources" key exists in the response
        if (!jsonResponse.has("sources")) {
            model.addAttribute("error", "No sources found in the response.");
            return "error"; // Show error if "sources" is missing
        }

        // Get the sources array from the JSON response
        JSONArray arr = jsonResponse.getJSONArray("sources");

        // Create a list to store the filtered news sources
        List<NewsSourceLang> newsLangList = new ArrayList<>();

        // Iterate over the sources and extract the required data
        for (int i = 0; i < arr.length(); i++) {
            JSONObject source = arr.getJSONObject(i);

            // Extract data for each source
            String name = source.optString("name", "No Title");
            String description = source.optString("description", "No Description");
            String urlArticle = source.optString("url", "#"); // Provide default URL if missing
            String country = source.optString("country", "Unknown");
            String lang = source.optString("language", "Unknown");

            // Check if the language matches the input parameter
            if (lang.equals(language)) {
                NewsSourceLang news = new NewsSourceLang(name, description, urlArticle, country, lang);
                newsLangList.add(news);
            }
        }

        // Add the filtered news sources to the model
        model.addAttribute("newsLangList", newsLangList);

        return "NewsLang";
    }

    

}

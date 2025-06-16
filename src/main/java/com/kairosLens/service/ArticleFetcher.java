package com.kairosLens.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ArticleFetcher {

    public String fetchArticleText(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.body().text(); // Simplified article text for now
        } catch (Exception e) {
            return "Error fetching article: " + e.getMessage();
        }
    }
}

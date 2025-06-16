package com.kairosLens.controller;

import com.kairosLens.service.ArticleFetcher;
import com.kairosLens.service.BiasAnalyzerService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnalysisController {

    private final ArticleFetcher fetcher;
    private final BiasAnalyzerService analyzer;

    public AnalysisController(ArticleFetcher fetcher, BiasAnalyzerService analyzer) {
        this.fetcher = fetcher;
        this.analyzer = analyzer;
    }

    @PostMapping("/analyze")
    public String analyze(@RequestBody String url) throws Exception {
        String articleText = fetcher.fetchArticleText(url);
        return analyzer.analyzeBias(articleText);
    }
}

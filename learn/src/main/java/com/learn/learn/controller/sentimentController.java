package com.learn.learn.controller;

import com.learn.learn.entite.Sentiment;
import com.learn.learn.enums.TypeSentiment;
import com.learn.learn.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path="sentiment", produces = APPLICATION_JSON_VALUE)
public class sentimentController {
    private SentimentService sentimentService;

    public sentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sentiment sentiment) {
        this.sentimentService.create(sentiment);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Sentiment> getSentiments(@RequestParam(required = false) TypeSentiment type) {
        return this.sentimentService.getSentiment(type);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteSentiment(@PathVariable int id) {
        this.sentimentService.deleteSentiment(id);
    }
}

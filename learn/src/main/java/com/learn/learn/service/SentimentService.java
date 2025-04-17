package com.learn.learn.service;

import com.learn.learn.entite.Client;
import com.learn.learn.entite.Sentiment;
import com.learn.learn.enums.TypeSentiment;
import com.learn.learn.reporitory.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {
    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment) {
        Client client = this.clientService.getOrCreate(sentiment.getClient());
        sentiment.setClient(client);

        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else{
            sentiment.setType(TypeSentiment.POSITIF);
        }

        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> getSentiment(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }

    }
    public void deleteSentiment(int id) {
        this.sentimentRepository.deleteById(id);
    }
}

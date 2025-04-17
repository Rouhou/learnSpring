package com.learn.learn.entite;

import com.learn.learn.enums.TypeSentiment;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;


@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private TypeSentiment type;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {

    }

    public Sentiment(int id, Client client, TypeSentiment type, String texte) {
        this.id = id;
        this.client = client;
        this.type = type;
        this.texte = texte;
    }

    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fundamental_rights")
public class FundamentalRight {

    @Id
    private String id;
    private String title;
    private String articles;

    @Column(length = 2000)
    private String description;

    protected FundamentalRight() {
    }

    public FundamentalRight(String id, String title, String articles, String description) {
        this.id = id;
        this.title = title;
        this.articles = articles;
        this.description = description;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArticles() { return articles; }
    public String getDescription() { return description; }
}

package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    private String id;
    private String title;
    private String author;
    private String date;

    @Column(length = 2000)
    private String content;

    private int views;

    protected Article() {
    }

    public Article(String id, String title, String author, String date, String content, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
        this.views = views;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }
    public String getContent() { return content; }
    public int getViews() { return views; }
}

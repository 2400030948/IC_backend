package com.constitutionhub.backendic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "constitution_parts")
public class ConstitutionPart {

    @Id
    private String id;
    private String part;
    private String title;
    private String articles;

    protected ConstitutionPart() {
    }

    public ConstitutionPart(String id, String part, String title, String articles) {
        this.id = id;
        this.part = part;
        this.title = title;
        this.articles = articles;
    }

    public String getId() { return id; }
    public String getPart() { return part; }
    public String getTitle() { return title; }
    public String getArticles() { return articles; }
}

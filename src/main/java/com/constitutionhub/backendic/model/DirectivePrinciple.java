package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "directive_principles")
public class DirectivePrinciple {

    @Id
    private String id;
    private int number;
    private String title;

    @Column(length = 2000)
    private String description;

    protected DirectivePrinciple() {
    }

    public DirectivePrinciple(String id, int number, String title, String description) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.description = description;
    }

    public String getId() { return id; }
    public int getNumber() { return number; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}

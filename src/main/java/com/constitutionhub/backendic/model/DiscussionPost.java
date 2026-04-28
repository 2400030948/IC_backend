package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discussion_posts")
public class DiscussionPost {

    @Id
    private String id;
    private String title;

    @Column(length = 3000)
    private String content;

    private String author;
    private String date;
    private int replies;
    private int views;

    protected DiscussionPost() {
    }

    public DiscussionPost(String id, String title, String content, String author, String date, int replies, int views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.replies = replies;
        this.views = views;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }
    public int getReplies() { return replies; }
    public int getViews() { return views; }
}

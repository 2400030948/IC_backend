package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "legal_faqs")
public class LegalFaq {

    @Id
    private String id;
    private String category;

    @Column(length = 1000)
    private String question;

    @Column(length = 3000)
    private String answer;

    protected LegalFaq() {
    }

    public LegalFaq(String id, String category, String question, String answer) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public String getId() { return id; }
    public String getCategory() { return category; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }

    public String category() { return category; }
    public String question() { return question; }
    public String answer() { return answer; }
}

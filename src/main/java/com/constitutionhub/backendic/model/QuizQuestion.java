package com.constitutionhub.backendic.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {

    @Id
    private String id;

    @Column(length = 1000)
    private String question;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "quiz_question_options", joinColumns = @JoinColumn(name = "question_id"))
    @OrderColumn(name = "option_order")
    @Column(name = "option_text")
    private List<String> options;

    private int answer;

    protected QuizQuestion() {
    }

    public QuizQuestion(String id, String question, List<String> options, int answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getId() { return id; }
    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
    public int getAnswer() { return answer; }

    public String id() { return id; }
    public String question() { return question; }
    public List<String> options() { return options; }
    public int answer() { return answer; }
}

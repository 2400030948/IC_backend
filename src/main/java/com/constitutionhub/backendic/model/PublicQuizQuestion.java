package com.constitutionhub.backendic.model;

import java.util.List;

public record PublicQuizQuestion(String id, String question, List<String> options) {
    public static PublicQuizQuestion from(QuizQuestion question) {
        return new PublicQuizQuestion(question.id(), question.question(), question.options());
    }
}

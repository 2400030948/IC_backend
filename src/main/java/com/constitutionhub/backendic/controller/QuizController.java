package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.dto.QuizResult;
import com.constitutionhub.backendic.dto.QuizSubmitRequest;
import com.constitutionhub.backendic.dto.QuizSubmitResponse;
import com.constitutionhub.backendic.model.PublicQuizQuestion;
import com.constitutionhub.backendic.model.QuizQuestion;
import com.constitutionhub.backendic.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final DataStore dataStore;

    public QuizController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping
    public List<PublicQuizQuestion> questions() {
        return dataStore.quizQuestions().stream()
                .map(PublicQuizQuestion::from)
                .toList();
    }

    @PostMapping("/submit")
    public QuizSubmitResponse submit(@RequestBody QuizSubmitRequest request) {
        List<Integer> answers = request.answers() == null ? List.of() : request.answers();
        List<QuizQuestion> questions = dataStore.quizQuestions();
        List<QuizResult> results = new ArrayList<>();
        int score = 0;

        for (int index = 0; index < questions.size(); index++) {
            QuizQuestion question = questions.get(index);
            Integer selected = index < answers.size() ? answers.get(index) : null;
            boolean isCorrect = selected != null && selected == question.answer();

            if (isCorrect) {
                score++;
            }

            results.add(new QuizResult(question.id(), selected, question.answer(), isCorrect));
        }

        int percentage = Math.round((score * 100f) / questions.size());
        return new QuizSubmitResponse(score, questions.size(), percentage, results);
    }
}

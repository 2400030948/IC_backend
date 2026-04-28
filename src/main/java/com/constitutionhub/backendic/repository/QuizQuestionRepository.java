package com.constitutionhub.backendic.repository;

import com.constitutionhub.backendic.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, String> {
}

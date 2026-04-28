package com.constitutionhub.backendic.dto;

import java.util.List;

public record QuizSubmitResponse(
        int score,
        int total,
        int percentage,
        List<QuizResult> results
) {
}

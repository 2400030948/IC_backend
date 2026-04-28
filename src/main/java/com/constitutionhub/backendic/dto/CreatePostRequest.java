package com.constitutionhub.backendic.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePostRequest(
        @NotBlank String title,
        @NotBlank String content,
        String author
) {
}

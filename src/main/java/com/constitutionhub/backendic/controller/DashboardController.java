package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.dto.MessageResponse;
import com.constitutionhub.backendic.service.DataStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DataStore dataStore;

    public DashboardController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping("/{role}")
    public ResponseEntity<?> dashboard(@PathVariable String role) {
        String normalizedRole = dataStore.normalizeRole(role);
        Map<String, Object> dashboard = switch (normalizedRole) {
            case "admin" -> Map.of(
                    "totalUsers", dataStore.users().size(),
                    "activeUsers", dataStore.users().stream().filter(user -> "Active".equals(user.status())).count(),
                    "totalArticles", dataStore.articles().size(),
                    "forumPosts", dataStore.discussionPosts().size()
            );
            case "educator" -> Map.of(
                    "publishedLessons", dataStore.articles().size(),
                    "quizQuestions", dataStore.quizQuestions().size(),
                    "learnerDiscussions", dataStore.discussionPosts().size()
            );
            case "citizen" -> Map.of(
                    "learningModules", dataStore.constitutionParts().size() + dataStore.fundamentalRights().size(),
                    "quizQuestions", dataStore.quizQuestions().size(),
                    "availableFaqs", dataStore.legalFaqs().size()
            );
            case "legal-expert" -> Map.of(
                    "legalQuestions", dataStore.legalFaqs().size(),
                    "forumPosts", dataStore.discussionPosts().size(),
                    "pendingGuidance", 3
            );
            default -> null;
        };

        if (dashboard == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("Dashboard role not found."));
        }

        return ResponseEntity.ok(dashboard);
    }
}

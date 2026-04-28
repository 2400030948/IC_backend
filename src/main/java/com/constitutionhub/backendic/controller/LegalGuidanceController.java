package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.dto.LegalGuidanceResponse;
import com.constitutionhub.backendic.model.LegalFaq;
import com.constitutionhub.backendic.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/legal-guidance")
public class LegalGuidanceController {

    private final DataStore dataStore;

    public LegalGuidanceController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping
    public LegalGuidanceResponse guidance(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "") String search
    ) {
        String query = search.trim().toLowerCase();
        List<LegalFaq> faqs = dataStore.legalFaqs().stream()
                .filter(faq -> category == null || category.isBlank() || faq.category().equals(category))
                .filter(faq -> query.isBlank()
                        || faq.question().toLowerCase().contains(query)
                        || faq.answer().toLowerCase().contains(query))
                .toList();

        return new LegalGuidanceResponse(List.of("rights", "duties", "constitution", "remedies"), faqs);
    }
}

package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.model.Article;
import com.constitutionhub.backendic.model.ConstitutionPart;
import com.constitutionhub.backendic.model.DirectivePrinciple;
import com.constitutionhub.backendic.model.FundamentalRight;
import com.constitutionhub.backendic.model.LegalFaq;
import com.constitutionhub.backendic.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final DataStore dataStore;

    public ContentController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping("/articles")
    public List<Article> articles() {
        return dataStore.articles();
    }

    @GetMapping("/constitution-parts")
    public List<ConstitutionPart> constitutionParts() {
        return dataStore.constitutionParts();
    }

    @GetMapping("/fundamental-rights")
    public List<FundamentalRight> fundamentalRights() {
        return dataStore.fundamentalRights();
    }

    @GetMapping("/fundamental-duties")
    public List<String> fundamentalDuties() {
        return dataStore.fundamentalDuties();
    }

    @GetMapping("/directive-principles")
    public List<DirectivePrinciple> directivePrinciples() {
        return dataStore.directivePrinciples();
    }

    @GetMapping("/legal-faq")
    public List<LegalFaq> legalFaq() {
        return dataStore.legalFaqs();
    }
}

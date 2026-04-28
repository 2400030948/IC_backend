package com.constitutionhub.backendic.dto;

import com.constitutionhub.backendic.model.LegalFaq;
import java.util.List;

public record LegalGuidanceResponse(List<String> categories, List<LegalFaq> faqs) {
}

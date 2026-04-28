package com.constitutionhub.backendic.repository;

import com.constitutionhub.backendic.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}

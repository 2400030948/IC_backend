package com.constitutionhub.backendic.repository;

import com.constitutionhub.backendic.model.DiscussionPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionPostRepository extends JpaRepository<DiscussionPost, String> {
    List<DiscussionPost> findAllByOrderByDateDesc();
}

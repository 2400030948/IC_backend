package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.dto.CreatePostRequest;
import com.constitutionhub.backendic.model.DiscussionPost;
import com.constitutionhub.backendic.service.DataStore;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/forum/posts")
public class ForumController {

    private final DataStore dataStore;

    public ForumController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping
    public List<DiscussionPost> posts() {
        return dataStore.discussionPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiscussionPost createPost(@Valid @RequestBody CreatePostRequest request) {
        String author = request.author() == null || request.author().isBlank() ? "Anonymous" : request.author();
        DiscussionPost post = new DiscussionPost(
                UUID.randomUUID().toString(),
                request.title(),
                request.content(),
                author,
                LocalDate.now().toString(),
                0,
                0
        );

        return dataStore.addDiscussionPost(post);
    }
}

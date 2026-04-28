package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.model.PublicUser;
import com.constitutionhub.backendic.service.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final DataStore dataStore;

    public UserController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping
    public List<PublicUser> users() {
        return dataStore.users().stream()
                .map(PublicUser::from)
                .toList();
    }
}

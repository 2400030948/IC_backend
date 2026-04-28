package com.constitutionhub.backendic.controller;

import com.constitutionhub.backendic.dto.AuthResponse;
import com.constitutionhub.backendic.dto.LoginRequest;
import com.constitutionhub.backendic.dto.MessageResponse;
import com.constitutionhub.backendic.dto.RegisterRequest;
import com.constitutionhub.backendic.dto.RegisterResponse;
import com.constitutionhub.backendic.model.PublicUser;
import com.constitutionhub.backendic.model.User;
import com.constitutionhub.backendic.service.DataStore;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HexFormat;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final DataStore dataStore;

    public AuthController(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return dataStore.findUserByEmail(request.email())
                .filter(user -> user.password().equals(request.password()))
                .<ResponseEntity<?>>map(user -> ResponseEntity.ok(new AuthResponse(
                        "Login successful.",
                        createToken(user),
                        PublicUser.from(user),
                        user.role()
                )))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new MessageResponse("Invalid email or password.")));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        if (dataStore.findUserByEmail(request.email()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("An account with this email already exists."));
        }

        User user = dataStore.addUser(
                request.name(),
                request.email(),
                request.password(),
                request.role()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegisterResponse("Account created successfully.", PublicUser.from(user)));
    }

    private String createToken(User user) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((user.id() + ":" + user.email() + ":" + Instant.now()).getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("SHA-256 is not available.", exception);
        }
    }
}

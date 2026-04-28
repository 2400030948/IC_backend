package com.constitutionhub.backendic.dto;

import com.constitutionhub.backendic.model.PublicUser;

public record AuthResponse(
        String message,
        String token,
        PublicUser user,
        String role
) {
}

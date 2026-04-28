package com.constitutionhub.backendic.dto;

import com.constitutionhub.backendic.model.PublicUser;

public record RegisterResponse(String message, PublicUser user) {
}

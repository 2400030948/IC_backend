package com.constitutionhub.backendic.model;

public record PublicUser(
        String id,
        String name,
        String email,
        String role,
        String status
) {
    public static PublicUser from(User user) {
        return new PublicUser(user.id(), user.name(), user.email(), user.role(), user.status());
    }
}

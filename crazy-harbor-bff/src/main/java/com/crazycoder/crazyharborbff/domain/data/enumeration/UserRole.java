package com.crazycoder.crazyharborbff.domain.data.enumeration;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum UserRole {

    ADMIN("ADMIN","Admin has control on everything."),
    USER("USER","User can view and comment posts.");

    private final String role;
    private final String description;

    UserRole(String role, String description) {
        this.role = role;
        this.description = description;
    }

}
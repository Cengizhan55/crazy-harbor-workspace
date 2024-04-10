package com.crazycoder.crazyharborbff.config.validation.validator;

import com.crazycoder.crazyharborbff.config.validation.annotations.UserRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class UserRoleValidator implements ConstraintValidator<UserRole, String> {
    @Override
    public void initialize(UserRole constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String userRole, ConstraintValidatorContext constraintValidatorContext) {

        List<String> userRoles = new ArrayList<>();
        userRoles.addAll(List.of("ADMIN", "USER"));

        if (userRoles.contains(userRole)) {
            return true;
        }
        return false;
    }
}

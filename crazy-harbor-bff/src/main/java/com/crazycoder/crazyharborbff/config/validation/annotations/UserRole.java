package com.crazycoder.crazyharborbff.config.validation.annotations;


import com.crazycoder.crazyharborbff.config.validation.validator.UserRoleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(value = {ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserRoleValidator.class)
@Documented
public @interface UserRole {

    String message () default "User Role must be ADMIN or USER";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

package com.crazycoder.crazyharborbff.domain.data.enumeration.converter;

import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
//import org.apache.commons.lang.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.stream.Stream;


public class UserRoleConverter {
}
/**
 * this class is deprecated, it was converter for harborUserRole.
 */ // todo: will be refactored

/*
@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String>, Serializable {

    @Serial
    private static final long serialVersionUID = -2566791780379999039L;

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.getRole();
    }

    @Override
    public UserRole convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }

        return Stream.of(UserRole.values())
                .filter(c -> StringUtils.equals(c.getRole(),role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

 */
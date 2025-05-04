package com.crazycoder.crazyharborbff.domain.service.harboruser.model;

import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class HarborUserResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1992188959784987201L;
    private String firstName;

    private String lastName;

    private Integer profileIconId;

    private String email;

    private String birthDate;

    private UserRole userRole;
    private String password;

    private List<String> relatedPosts;
    private LocalDateTime createDate;
}

package com.crazycoder.crazyharborbff.domain.service.harboruser.model;

import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserRoleDTO;
import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class HarborUserListDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1627399945250475328L;
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

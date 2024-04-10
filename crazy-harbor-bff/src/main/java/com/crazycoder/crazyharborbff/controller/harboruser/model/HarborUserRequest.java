package com.crazycoder.crazyharborbff.controller.harboruser.model;

import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class HarborUserRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = 2493560761783000252L;
    @NotBlank
    @Size(min = 2,max = 20)
    private String firstName;

    @NotNull
    private String lastName;

    private Integer profileIconId;

    @Email
    private String email;


    private String birthDate;

    //@UserRole
    private UserRole userRole;
    private String password;

    private List<String> relatedPosts;
    private LocalDateTime createDate;
}

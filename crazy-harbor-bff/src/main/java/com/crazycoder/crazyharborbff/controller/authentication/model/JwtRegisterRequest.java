package com.crazycoder.crazyharborbff.controller.authentication.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRegisterRequest {

    private String firstname;

    private String lastname;

    private String username;

    private String password;
}

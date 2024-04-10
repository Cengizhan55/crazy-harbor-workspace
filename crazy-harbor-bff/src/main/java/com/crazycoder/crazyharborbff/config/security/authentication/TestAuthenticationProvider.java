package com.crazycoder.crazyharborbff.config.security.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public class TestAuthenticationProvider {
    /*

    private final List<String> passwords;

    public TestAuthenticationProvider(List<String> passwords) {
        this.passwords = passwords;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var authRequest = (TestAuthentication) (authentication);
        String password = authRequest.getPassword();

        if (!passwords.contains(password)) {
            throw new BadCredentialsException("You are not from harbor ui");
        }
        return TestAuthentication.authenticated();

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TestAuthentication.class.isAssignableFrom(authentication);
    }

     */
}

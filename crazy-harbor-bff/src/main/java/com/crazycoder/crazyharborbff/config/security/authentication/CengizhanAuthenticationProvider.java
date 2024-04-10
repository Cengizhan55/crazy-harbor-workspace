package com.crazycoder.crazyharborbff.config.security.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public class CengizhanAuthenticationProvider  {
    /*
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        if ("cengizhan".equals(username)) {
            return UsernamePasswordAuthenticationToken.authenticated(
                    "cengizhan",
                    null,
                    AuthorityUtils.createAuthorityList("ROLE_ADMIN")
            );
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

     */
}

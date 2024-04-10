package com.crazycoder.crazyharborbff.config.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestAuthentication {
    /*

    private final boolean isAuthenticated;

    private final String password;

    private final List<GrantedAuthority> authorities;// WE CREATED specail one


    private TestAuthentication(String password, List<GrantedAuthority> authorities) {
        this.password = password;
        this.authorities = authorities;
        this.isAuthenticated = password == null;
    }

    public static TestAuthentication unauthenticated (String password){
        return new TestAuthentication(password,Collections.emptyList());
    }

    public static TestAuthentication authenticated (){
        return new TestAuthentication(null,AuthorityUtils.createAuthorityList("ROLE_TEST_ADMIN"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return getName();
    }

    @Override
    public boolean isAuthenticated() {

        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

        throw new IllegalArgumentException("Don't do that , note: Cengizhan from Harbor Team , we dont set we create empty then load the context");
    }

    @Override
    public String getName() {
        return "TestAuthentication -> getName method returned.";
    }

    public String getPassword() {
        return password;
    }

     */
}

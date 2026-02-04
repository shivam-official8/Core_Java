package com.example.ecommerce.entity;


import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private Users users;
    public UserPrincipal(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + users.getRole().name())
        );
    }


    @Override
    public @Nullable String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


//write prompt for vercel v0 to create sorting algo visualization in react .jsx file type algos like insertion, merge, quick and heap in heap it should also visualise by creating tree and on each step it should show equation and condition applied according to algo on tht step it should have two modes manual and ml model in manual user enters array data and selects which algo he need to visualise and inside tht lso he given 2 options auto or step by step where in auto runs auto but in step by step it give button to next and pprev step and visualisation should be done like array boxes inside the given data of numbers is written
package com.maluxinyu.cloud.user.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @PreAuthorize("hasRole('USER')")
    public String user() {
        var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Home: USER - Username: " + jwt.getSubject();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Home: ADMIN - Username: " + jwt.getSubject();
    }

}

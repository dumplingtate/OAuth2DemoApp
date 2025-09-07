package org.example.oauth2demoapp.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
public class User {
    private Long id;
    private String username;
    private String password;

    private Collection<GrantedAuthority> authorities;

    private List<Order> orders;
}

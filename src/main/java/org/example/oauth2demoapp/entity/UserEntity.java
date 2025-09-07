package org.example.oauth2demoapp.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
public class UserEntity {
    private Long id;
    private String username;
    private String password;

    private Collection<GrantedAuthority> authorities;

    private List<OrderEntity> orders;
}

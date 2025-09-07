package org.example.oauth2demoapp.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(Long id){
        return userRepository.getById(id);
    }
}

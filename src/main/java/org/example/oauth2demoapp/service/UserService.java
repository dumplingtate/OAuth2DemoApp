package org.example.oauth2demoapp.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2demoapp.entity.User;
import org.example.oauth2demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findOrCreateUser(String username, String email, String githubId) {
        return userRepository.findByGithubId(githubId)
                .orElseGet(() ->{
                        User newUser = new User(username, email, githubId);
                        return userRepository.save(newUser);
                });
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}

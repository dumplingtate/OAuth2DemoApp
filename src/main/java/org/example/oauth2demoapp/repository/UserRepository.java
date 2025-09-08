package org.example.oauth2demoapp.repository;

import org.example.oauth2demoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByGithubId(String githubId);
    Optional<User> findByUsername(String username);
}

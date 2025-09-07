package org.example.oauth2demoapp.repository;

import org.example.oauth2demoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getById(Long Id);

   public User getByUsername(String username);
}

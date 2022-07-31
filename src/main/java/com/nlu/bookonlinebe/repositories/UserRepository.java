package com.nlu.bookonlinebe.repositories;

import com.nlu.bookonlinebe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String username);
    public List<User> findByUsernameContainingIgnoreCase(String keyword);
    public User findUserByEmailAndPassword(String email, String password);
    public Optional<User> findByUsernameAndPassword(String username,String password);
}

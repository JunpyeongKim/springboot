package com.example.repository.user;


import com.example.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneByUsername(String username);

    public List<User> findAllByUsername(String username);

    public User findByUsernameAndPassword(String username, String password);

    public List<User> findAllByRole(String role);
}

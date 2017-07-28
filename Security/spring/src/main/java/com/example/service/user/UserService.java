package com.example.service.user;


import com.example.domain.user.User;
import com.example.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> create(List<User> users) {
        List<User> created = userRepository.save(users);
        return created;
    }

    //--------------------------------------------------------------------------------
    public User findOneByUsername(String username) {
        User user = userRepository.findOneByUsername(username);
        return user;
    }

    public List<User> findAllByUsername(String username) {
        List<User> users = userRepository.findAllByUsername(username);
        return users;
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    public List<User> findAllByRole(String role) {
        List<User> users = userRepository.findAllByRole(role);
        return users;
    }

    //--------------------------------------------------------------------------------
    // Access Failure
    public User updateUserMetaInfo(User user) {
//        String username = user.getUsername();
//        List<User> users = userRepository.findByUsername(username);
        User updated = null;
//        if (users != null && users.size() > 0) {
//            for (User user1 : users) {
//                if (username.equals((user1.getUsername()))) {
//                    updated = userRepository.save(user);
//                }
//            }
//        }
        updated = userRepository.save(user);

        return updated;
    }

    // Access Time

    // Lock: when 4 failure

    //
}

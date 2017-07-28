package com.example.api.user;


import com.example.domain.user.User;
import com.example.repository.user.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "users", description = "User")
@RestController
@CrossOrigin
@RequestMapping("users")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> postUsers(@RequestBody List<User> users) {
        List<User> created = userRepository.save(users);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    /*
    @RequestMapping(method = RequestMethod.PUT)
    public List<User> putUsers(@RequestBody List<User> users) {
        List<User> updated = userRepository.save(users);
        return updated;
    }
    */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User putUser(@PathVariable Long id,
                        @RequestBody User user) {
        User found = userRepository.findOne(id);
        User updated = null;

        if (found != null) {
            updated = userRepository.save(user);
        }

        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsers() {
        userRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        //TODO: handling unfound id


        // and then delete a specific id
        userRepository.delete(id);
    }
}

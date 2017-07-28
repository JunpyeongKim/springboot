package com.example.api.user;


import com.example.domain.user.Role;
import com.example.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api
@RestController
@CrossOrigin
@RequestMapping("roles")
public class RoleRestController {
    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Role> postRoles(@RequestBody List<Role> roles) {
        List<Role> created = roleRepository.save(roles);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Role getRole(@PathVariable Long id) {
        Role role = roleRepository.findOne(id);
        return role;
    }

    //TODO: necessary ???
    @RequestMapping(method = RequestMethod.PUT)
    public List<Role> putRoles(@RequestBody List<Role> roles) {
        List<Role> updated = roleRepository.save(roles);
        return updated;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Role putRole(@PathVariable Long id,
                        @RequestBody Role role) {
        Role found = roleRepository.findOne(id);
        Role updated = null;

        if (found != null) {
            updated = roleRepository.save(role);
        }

        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoles() {
        roleRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable Long id) {
        //TODO: handling unfound id

        // and then delete a specific id
        roleRepository.delete(id);
    }
}

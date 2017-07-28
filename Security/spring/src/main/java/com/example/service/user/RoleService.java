package com.example.service.user;


import com.example.domain.user.Role;
import com.example.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> create(List<Role> roles) {
        List<Role> created = roleRepository.save(roles);
        return created;
    }

    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    public Role findOne(Long id) {
        Role role = roleRepository.findOne(id);
        return role;
    }


}

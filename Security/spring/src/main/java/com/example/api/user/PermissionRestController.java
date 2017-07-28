package com.example.api.user;


import com.example.domain.user.Permission;
import com.example.domain.user.Role;
import com.example.repository.user.PermissionRepository;
import com.example.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("permissions")
public class PermissionRestController {
    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Permission> postPermissions(@RequestBody List<Permission> permissions) {
        List<Permission> created = permissionRepository.save(permissions);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Permission> getPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Permission getPermission(@PathVariable Long id) {
        Permission permission = permissionRepository.findOne(id);
        return permission;
    }

    //TODO: necessary ???
    @RequestMapping(method = RequestMethod.PUT)
    public List<Permission> putPermissions(@RequestBody List<Permission> permissions) {
        //TODO: 존재하는 permission 만 업데이트 가능하도록...
        List<Permission> updated = permissionRepository.save(permissions);
        return updated;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Permission putPermission(@PathVariable Long id,
                                    @RequestBody final Permission permission) {
        Permission found = permissionRepository.findOne(id);
        Permission updated = null;
        List<Role> roles;

        if (found != null) {
            //TODO: permission 필드 업데이트

            //TODO: relation update by Stream & Map
            roles = found.getRoles();

            List<Role> newRoles = permission.getRoles();
            if (roles != null) {
                if (roles.size() > 0) {
                    //TODO:
                } else {
//                    roles.addAll(newRoles); // owner 가 아니므로 이걸로 join table 업데이트가 안된다. 즉, 관계설정 불가

                    Long Id;
                    Role temp;
                    List<Role> roles1 = new ArrayList<Role>();
                    for (Role role : newRoles) {
                        Id = role.getId();
                        temp = roleRepository.findOne(Id);
                        if (temp != null) {
//                            temp.addPermission(permission);
                            temp.getPermissions().add(permission);
                        }
                        roles1.add(temp);
                    }
                    List<Role> updatedRole = roleRepository.save(roles1);

//                    roles.addAll(permission.getRoles());
                }
            } else {
                //TODO:
            }


//            for (Role role : roles) {
//                role.addPermission(permission);
//            }
//            List<Role> updatedRole = roleRepository.save(roles);

            updated = permissionRepository.findOne(id);   //save(found);
        }

        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePermissions() {
        // Role 에서 삭제
        // permission 사용중인 Role 검색후 Role 업데이트
        // 이후 permission 삭제
        //TODO: use Stream
        List<Role> roles = roleRepository.findAll();

        roles.forEach(role -> {
            List<Permission> permissions = role.getPermissions();
            permissions.clear();
        });

        List<Role> updated = roleRepository.save(roles);


        // 이후 Permission 삭제 가능
        permissionRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePermission(@PathVariable Long id) {
        //TODO: handling unfound id


        // and then delete a specific id

        // Role 에서 삭제
        // permission 사용중인 Role 검색후 Role 업데이트
        // 이후 permission 삭제
        //TODO: use Stream
        List<Role> roles = roleRepository.findAll();

        roles.forEach(role -> {
            List<Permission> permissions = role.getPermissions();
            List<Permission> updated = new ArrayList<Permission>();
            for (Permission permission : permissions) {
                if (permission.getId() != id) {
                    updated.add(permission);
                }
            }
            permissions.clear();
            permissions.addAll(updated);
        });

        List<Role> updated = roleRepository.save(roles);


        // 이후 Permission 삭제 가능
        permissionRepository.delete(id);
    }
}

package com.example.domain.user;


///* dummy
public class LoginUserDetails {

}
//*/

/*
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
    private User user;
//    private String role;
//    private List<Permission> permissions;
//    private String authList;
//    private String[] authList2;

    public LoginUserDetails(User user) {
//        (String username, String password, boolean enabled,
//        boolean accountNonExpired, boolean credentialsNonExpired,
//        boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)

        super(user.getUsername(),
                user.getPassword(),
                true,   // enabled
                true,   // accountNonExpired
                true,   // credentialsNonExpired
                true,  // accountNonLocked
                AuthorityUtils.createAuthorityList(
//                        "USER", "ADMIN", "ROLE"
//                        PermissionParser.parse(user.getRole().getPermissions())
                        PermissionParser.parseToArray(user.getRole().getPermissions())
                )
        );

        this.user = user;
//        this.role = user.getRole().getName();
//        this.permissions = user.getRole().getPermissions();
//        this.authList = PermissionParser.parse(this.permissions);
//        this.authList2 = PermissionParser.parseToArray(this.permissions);
    }

    static class PermissionParser {
        static String parse(List<Permission> permissions) {
            List<String> permissionBuffer = new ArrayList<String>();
            String permissionList;
            String name;

            if (permissions == null || permissions.size() <= 0) {
                return "ANONYMOUS";
            }

            for (Permission permission : permissions) {
                name = permission.getName();
                permissionBuffer.add(name);
            }

//            permissionList = Arrays.toString(permissionBuffer.toArray());
            permissionList = StringUtils.join(permissionBuffer, ", ");

            return permissionList;
        }

        static String[] parseToArray(List<Permission> permissions) {
            List<String> permissionBuffer = new ArrayList<String>();
            String[] permissionList;
            String name;

            if (permissions == null || permissions.size() <= 0) {
                return new String[] {"ANONYMOUS"};
            }

            for (Permission permission : permissions) {
                name = permission.getName();
                permissionBuffer.add(name);
            }

            permissionList = new String[permissionBuffer.size()];
            permissionList = permissionBuffer.toArray(permissionList);
            return permissionList;
        }
    }
}
//*/

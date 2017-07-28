package com.example.domain.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //TODO: instead of String, Boolean ???
    // 사용 여부
    private String useYn;

    //----------------------------------------------------------------
    // Relationship
    // Statistics Only
//    @OneToMany(mappedBy = "role")
//    private List<User> users;



    //TODO: ROLE - ROLE_PERMISSION / PRIVILEGE - PERMISSION
    //TODO: 비즈니스 분석 상...cascade 는 사용하지 않는 것이 좋겠다.
    // TODO: List --> Set, 중복된 롤은 가질 수 없도록..
    @ManyToMany
    @JoinTable(name = "TBL_ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
//    @NotFound(action = NotFoundAction.EXCEPTION)
    private List<Permission> permissions;


    public void addPermission(Permission permission) {
        if (permissions == null) {
            permissions = new ArrayList<Permission>();
        }

        permissions.add(permission);
        permission.getRoles().add(this);    // TODO: array null check
    }


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "ROLE_PAGE",
//            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "PAGE_ID", referencedColumnName = "ID"))
//    private List<Page> pages;

//    @ManyToMany
//    private List<Button> buttons;
}

package com.example.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_PERMISSION", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Data
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue
    private Long id;

    // url, button, 등록/수정/조회/삭제/엑셀
    private String name;

    private String dispName;

    // 사용 여부
    private String useYn;

    // state/path, action/button/operation
    private String type;

    //----------------------------------------------------------------
    // Relationship
    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference
    private List<Role> roles;


    // not owner --> optional
    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<Role>();
        }

        roles.add(role);
        role.getPermissions().add(this);    // TODO: array null check
    }
}

package com.example.domain.user;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;

    private String name;

    // Optional
    @ManyToMany(mappedBy = "products")
    List<Member> members;

    //--------------------------------------------------------------------------------
    // Convenient Method : either Member's or Product's --> Usually Owner's
    //--------------------------------------------------------------------------------
//    public void addMember(Member member) {
//        if (members == null) {
//            members = new ArrayList<Member>();
//        }
//
//        members.add(member);
//        member.getProducts().add(this);
//    }
}

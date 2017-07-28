package com.example.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Member {
    @Id
    private String id;

    private String name;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
    List<Product> products;

    //--------------------------------------------------------------------------------
    // Convenient Method : either Member's or Product's --> Usually Owner's
    //--------------------------------------------------------------------------------
    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<Product>();
        }

        products.add(product);
        product.getMembers().add(this);
    }
}

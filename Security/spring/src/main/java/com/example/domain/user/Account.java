package com.example.domain.user;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
//@Data
//@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}

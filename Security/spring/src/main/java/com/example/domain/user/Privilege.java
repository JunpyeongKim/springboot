package com.example.domain.user;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Privilege {
    @JsonProperty
    protected String name;
}

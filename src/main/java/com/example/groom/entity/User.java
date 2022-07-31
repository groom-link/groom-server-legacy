package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Users")
@Getter
public class User extends BaseEntity{
    @Column
    private String username;

    @Column
    private String password;
}

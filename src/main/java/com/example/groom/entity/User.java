package com.example.groom.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    @Column
    private String username;

    @Column
    private String password;
}

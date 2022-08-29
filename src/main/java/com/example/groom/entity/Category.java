package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Category extends BaseEntity{
    @Column
    private String name;

    @Column
    private Long depth;

    @OneToMany
    private List<Category> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category parent;

    @Column
    private String colorHex;

}

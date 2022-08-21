package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Tag extends BaseEntity{
    @Column
    private String name;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column
    private String colorHex;

}

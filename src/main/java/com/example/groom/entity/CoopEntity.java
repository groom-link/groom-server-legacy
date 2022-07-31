package com.example.groom.entity;


import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class CoopEntity extends OwnEntity{
    @LastModifiedBy
    private Long modifier;
}

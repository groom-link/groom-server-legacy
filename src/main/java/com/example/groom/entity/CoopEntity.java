package com.example.groom.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class CoopEntity extends OwnEntity{
    @LastModifiedBy
    private Long modifier;
}

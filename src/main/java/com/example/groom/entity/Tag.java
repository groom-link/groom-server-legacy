package com.example.groom.entity;


import com.example.groom.domain.tag.dto.TagPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity{
    @Column
    private String name;

    public static Tag of(TagPostDto tagPostDto){
        return new Tag(tagPostDto.getName());
    }
}

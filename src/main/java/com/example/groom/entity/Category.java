package com.example.groom.entity;


import com.example.groom.domain.category.dto.CategoryPostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorColumn
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    static public Category of(CategoryPostDto categoryDto, Category parent){
        return Category.builder().name(categoryDto.getName()).depth(parent.getDepth() + 1).parent(parent).build();
    }

}

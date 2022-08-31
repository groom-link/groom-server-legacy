package com.example.groom.domain.category.dto;


import lombok.Data;

@Data
public class CategoryPostDto {
    private String name;

    private Long depth;

    private Long parent_id;

    public CategoryPostDto(String name, Long depth, Long parent_id) {
        this.name = name;
        this.depth = depth;
        this.parent_id = parent_id;
    }
}

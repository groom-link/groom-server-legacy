package com.example.groom.domain.category.dto;


import com.example.groom.entity.domain.category.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private String name;

    private Long depth;

    private List<CategoryDto> children;

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.depth = category.getDepth();
        this.children = category.getChildren().stream().map(CategoryDto::new).toList();
    }
}

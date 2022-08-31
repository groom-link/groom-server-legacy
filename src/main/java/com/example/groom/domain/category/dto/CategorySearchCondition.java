package com.example.groom.domain.category.dto;

import lombok.Data;

@Data
public class CategorySearchCondition {
    private Long depth;
    private Long parent_id;
    private String name;
}

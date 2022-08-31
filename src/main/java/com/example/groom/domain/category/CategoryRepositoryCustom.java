package com.example.groom.domain.category;

import com.example.groom.domain.category.dto.CategoryDto;
import com.example.groom.domain.category.dto.CategorySearchCondition;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategoryDto> search(CategorySearchCondition condition);
}

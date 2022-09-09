package com.example.groom.domain.category;


import com.example.groom.domain.category.dto.CategoryDto;
import com.example.groom.domain.category.dto.CategoryPostDto;
import com.example.groom.domain.category.dto.CategorySearchCondition;
import com.example.groom.entity.domain.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> searchCategories(CategorySearchCondition condition){
        return this.categoryService.search(condition);
    }

    @PostMapping
    public Category postCategory(@RequestBody CategoryPostDto categoryPostDto){
        return this.categoryService.postCategory(categoryPostDto);
    }
}

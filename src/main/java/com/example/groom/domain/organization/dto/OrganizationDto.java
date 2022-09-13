package com.example.groom.domain.organization.dto;


import com.example.groom.domain.category.dto.CategoryDto;
import com.example.groom.entity.domain.category.Category;
import com.example.groom.entity.domain.organization.Organization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrganizationDto {
    private Long id;
    private String name;
    private String description;
    private CategoryDto category;

    public OrganizationDto(Long id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = CategoryDto.of(category);
    }

    public static OrganizationDto of(Organization organization) {
        return new OrganizationDto(organization.getId(), organization.getName(), organization.getDescription(), organization.getCategory());
    }
}

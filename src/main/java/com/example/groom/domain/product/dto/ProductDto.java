package com.example.groom.domain.product.dto;


import com.example.groom.domain.organization.dto.OrganizationDto;
import com.example.groom.entity.domain.product.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {
    private Long id;
    private String thumbnailImage;
    private OrganizationDto organization;
    private Long price;
    private String name;

    private ProductDto(Product product) {
        this.price = product.getPrice();
        this.id = product.getId();
        this.thumbnailImage = product.getThumbnailImage();
        this.name = product.getName();
        this.organization = OrganizationDto.of(product.getOrganization());
    }

    static public ProductDto of(Product product){
        return new ProductDto(product);
    }
}

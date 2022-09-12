package com.example.groom.domain.product;

import com.example.groom.domain.product.dto.ProductDto;
import com.example.groom.domain.product.dto.ProductSearchCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ProductRepositoryCustom {
    Slice<ProductDto> search(Pageable pageable, ProductSearchCondition productSearchCondition);
}

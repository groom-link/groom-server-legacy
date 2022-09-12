package com.example.groom.domain.product;


import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.product.dto.ProductDto;
import com.example.groom.domain.product.dto.ProductPostDto;
import com.example.groom.domain.product.dto.ProductSearchCondition;
import com.example.groom.entity.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository gifticonRepository;

    public Product save(ProductPostDto productPostDto){
        Product product = Product.of(productPostDto);
        return this.gifticonRepository.save(product);
    }

    public Slice<ProductDto> search(Pageable pageable, ProductSearchCondition productSearchCondition){
        return this.gifticonRepository.search(pageable, productSearchCondition);
    }

    public ProductDto findById(Long id) {
        Product product = this.gifticonRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.PRODUCT_NOT_FOUND));
        return ProductDto.of(product);
    }

    public Long deleteById(Long id) {
        this.gifticonRepository.deleteById(id);
        return id;
    }
}

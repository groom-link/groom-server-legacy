package com.example.groom.domain.product;

import com.example.groom.domain.product.dto.ProductDto;
import com.example.groom.domain.product.dto.ProductSearchCondition;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.groom.entity.domain.organization.QOrganization.organization;
import static com.example.groom.entity.domain.product.QProduct.product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    protected ProductRepositoryImpl(EntityManager em){
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Slice<ProductDto> search(Pageable pageable, ProductSearchCondition productSearchCondition) {
        List<ProductDto> productDtos = query.select(Projections.constructor(ProductDto.class, product.id, product.thumbnailImage, product.organization, product.price, product.name))
                .from(product)
                .where(productSearchCondition.getCondition())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query.select(product.count()).from(product).where(productSearchCondition.getCondition())
                .fetchOne();

        return new PageImpl<>(productDtos, pageable, count);
    }
}

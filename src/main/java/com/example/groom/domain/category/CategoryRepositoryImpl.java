package com.example.groom.domain.category;

import com.example.groom.domain.category.dto.CategoryDto;
import com.example.groom.domain.category.dto.CategorySearchCondition;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.QCategory.category;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public CategoryRepositoryImpl(EntityManager em) {

        this.query = new JPAQueryFactory(em);
    }


    @Override
    @Transactional
    public List<CategoryDto> search(CategorySearchCondition condition) {
        return query.select(Projections.constructor(CategoryDto.class, category.name, category.depth, category.children))
                .from(category)
                .where(category.name.contains(condition.getName()),
                        category.depth.eq(condition.getDepth()),
                        category.parent.id.eq(condition.getParent_id())
                )
                .fetch();
    }
}

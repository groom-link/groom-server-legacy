package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.entity.Token;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.example.groom.entity.QRefreshToken.refreshToken1;


public class RefreshTokenRepositoryImpl implements RefreshTokenRepositoryCustom {



    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RefreshTokenRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }




    @Override
    public Token getRefreshTokenFromDB(String refreshToken) {
        Token existsToken = query.selectFrom(refreshToken1)
                .where(refreshToken1.refreshToken.eq(refreshToken))
                .fetchOne();
        if (existsToken == null) throw new CustomException(ErrorCode.REFRESH_TOKEN_INVALID);
        return existsToken;
    }


}

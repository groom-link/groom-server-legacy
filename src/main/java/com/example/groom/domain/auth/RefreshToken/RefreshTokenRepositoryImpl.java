package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.common.customRepository.RefreshTokenRepositoryCustom;
import com.example.groom.entity.RefreshToken;
import com.example.groom.entity.UserInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;

import static com.example.groom.entity.QRefreshToken.refreshToken1;
import static java.time.LocalDateTime.now;


public class RefreshTokenRepositoryImpl implements RefreshTokenRepositoryCustom {

    @Value("${jwt.refresh.expirationDay}")
    private Long expirationDay;

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RefreshTokenRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }


    private boolean isExpired(LocalDateTime createdAt){
        return createdAt.plusDays(expirationDay).isBefore(now());
    }

    @Override
    public Boolean checkRefreshToken(String refreshToken, UserInfo userInfo) {
        RefreshToken existsRefreshToken = query.selectFrom(refreshToken1)
                .where(
                        refreshToken1.userInfo.eq(userInfo),
                        refreshToken1.refreshToken.eq(refreshToken)
                )
                .fetchOne();
        if(existsRefreshToken == null)return false;
        if(isExpired(existsRefreshToken.getCreatedAt()))em.remove(existsRefreshToken);
        return true;
    }

    @Override
    public void insertRefreshToken(String refreshToken, UserInfo userInfo) {
        em.persist(new RefreshToken(refreshToken,userInfo));
    }

}

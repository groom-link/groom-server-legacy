package com.example.groom.entity.domain.gifticon;


import com.example.groom.entity.common.BaseEntity;
import com.example.groom.entity.domain.company.Company;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gifticon extends BaseEntity {
    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private String thumbnailImage;

    @JoinColumn
    @ManyToOne
    private Company company;

    static public Gifticon of(Long id){
        return new Gifticon(id);
    }
    private Gifticon(Long gifticonId) {
        super(gifticonId);
    }
}

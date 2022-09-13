package com.example.groom.entity;

import com.example.groom.entity.common.OwnEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class File extends OwnEntity {

    @Column
    private String ext;

    @Column
    private String originName;

    @Column
    private String uuid;

    @Column
    private String url;
}

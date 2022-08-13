package com.example.groom.domain.todo.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class TodoRepositoryCustomImpl implements TodoRepositoryCustom {
    @Autowired
    private EntityManager em;


}

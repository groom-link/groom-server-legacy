package com.example.groom.domain.todo.Repository;

import com.example.groom.entity.Todo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.QTodo.todo;

public class TodoRepositoryCustomImpl implements TodoRepositoryCustom{

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public TodoRepositoryCustomImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<Todo> findAllByUserIdRoomId(Long roomId, Long userInfoId) {
        List<Todo> todoList = query.selectFrom(todo)
                .where(todo.userInfo.id.eq(userInfoId).and(todo.room.id.eq(roomId)))
                .fetch();

        return todoList;
    }
}

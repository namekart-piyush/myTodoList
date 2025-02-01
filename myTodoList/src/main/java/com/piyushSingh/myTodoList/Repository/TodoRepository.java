package com.piyushSingh.myTodoList.Repository;

import com.piyushSingh.myTodoList.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}

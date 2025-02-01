package com.piyushSingh.myTodoList.config;

import com.piyushSingh.myTodoList.Entity.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "TodoClient",url = "http://localhost:8080")
public interface TodoClient {
    @GetMapping("/api/todos")
    List<Todo> getTodos();
}

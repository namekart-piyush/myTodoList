package com.piyushSingh.myTodoList.Service;

import com.piyushSingh.myTodoList.Entity.Todo;
import com.piyushSingh.myTodoList.Repository.TodoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Service
public class AsyncService {


    @Autowired
    private TodoService todoService;

    @Async("taskExecutor")
    public CompletableFuture<List<Todo>> gotTodo() {
        // Simulate a delay
        try {
            Thread.sleep(5000);  // simulate long running task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<Todo> todos = todoService.getAllTodos();
        return CompletableFuture.completedFuture(todos);
    }
}

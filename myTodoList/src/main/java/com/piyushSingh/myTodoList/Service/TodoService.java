package com.piyushSingh.myTodoList.Service;

import com.piyushSingh.myTodoList.Entity.Todo;
import com.piyushSingh.myTodoList.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getById(Long id){
        return todoRepository.findById(id);
    }

    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id,Todo todo){
        if(todoRepository.existsById(id)){
            todo.setId(id);
            return todoRepository.save(todo);
        }else{
            return null;
        }

    }

    public boolean deleteTodo(Long id){
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}

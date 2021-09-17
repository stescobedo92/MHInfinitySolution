package com.mhinfinitysolution.todo.services;

import com.mhinfinitysolution.todo.model.Todo;
import com.mhinfinitysolution.todo.repository.ITodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService implements ITodoService{
    private final ITodoRepository _todoRepository;

    public TodoService(ITodoRepository todoRepository ){
        _todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodoList() {
        return _todoRepository.findAll();
    }

    @Override
    public Todo getTodo(int todoId) {
        Optional<Todo> todo = _todoRepository.findById(todoId);

        return todo.orElse(null);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return _todoRepository.save(todo);
    }

    @Override
    public boolean deleteTodo(int id) {
        boolean deleted = false;
        Optional<Todo> todo = _todoRepository.findById(id);

        if (todo.isPresent()) {
            _todoRepository.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
}

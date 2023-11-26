package todo.spring.app.service;

import todo.spring.app.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    Todo getTodo(Long id);

    Todo createTodo(Todo todo);

    Todo updateTodo(Long id, Todo updatedTodo);

    void deleteTodo(Long id);
}

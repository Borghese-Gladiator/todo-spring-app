package todo.spring.app.repository;

import todo.spring.app.entity.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();

    Todo findById(Long id);

    Todo save(Todo todo);

    void deleteById(Long id);
}

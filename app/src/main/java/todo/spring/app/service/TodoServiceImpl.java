package todo.spring.app.service;

import todo.spring.app.entity.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoServiceImpl implements TodoService {
    private final List<Todo> todoList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    @Override
    public List<Todo> getAllTodos() {
        return todoList;
    }

    public Todo getTodo(Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public Todo createTodo(Todo todo) {
        long id = idCounter.incrementAndGet();
        todo.setId(id);
        todoList.add(todo);
        return todo;
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setDescription(updatedTodo.getDescription());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null; // Handle if the todo with given id is not found
    }

    public void deleteTodo(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }
}

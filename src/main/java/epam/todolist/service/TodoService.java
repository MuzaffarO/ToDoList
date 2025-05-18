package epam.todolist.service;

import epam.todolist.model.Todo;
import epam.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return repository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, Todo updated) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            return repository.save(existing);
        });
    }

    public boolean deleteTodo(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

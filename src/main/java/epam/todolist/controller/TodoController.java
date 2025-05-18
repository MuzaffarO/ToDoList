package epam.todolist.controller;

import epam.todolist.model.Todo;
import epam.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getAll() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOne(@PathVariable Long id) {
        return service.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.deleteTodo(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

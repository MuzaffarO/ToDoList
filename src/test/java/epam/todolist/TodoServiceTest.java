package epam.todolist;

import epam.todolist.model.Todo;
import epam.todolist.repository.TodoRepository;
import epam.todolist.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    @Mock
    private TodoRepository repository;

    @InjectMocks
    private TodoService service;

    private Todo todo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        todo = Todo.builder().id(1L).title("Test").description("Desc").build();
    }

    @Test
    void testCreateTodo() {
        when(repository.save(todo)).thenReturn(todo);
        Todo saved = service.createTodo(todo);
        assertEquals(todo.getTitle(), saved.getTitle());
    }

    @Test
    void testGetAllTodos() {
        when(repository.findAll()).thenReturn(List.of(todo));
        List<Todo> todos = service.getAllTodos();
        assertEquals(1, todos.size());
    }

    @Test
    void testGetTodoById() {
        when(repository.findById(1L)).thenReturn(Optional.of(todo));
        Optional<Todo> found = service.getTodoById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    void testUpdateTodo() {
        Todo updated = Todo.builder().title("Updated").description("New Desc").build();
        when(repository.findById(1L)).thenReturn(Optional.of(todo));
        when(repository.save(any())).thenReturn(updated);
        Optional<Todo> result = service.updateTodo(1L, updated);
        assertTrue(result.isPresent());
        assertEquals("Updated", result.get().getTitle());
    }

    @Test
    void testDeleteTodo() {
        when(repository.existsById(1L)).thenReturn(true);
        doNothing().when(repository).deleteById(1L);
        assertTrue(service.deleteTodo(1L));
    }
}

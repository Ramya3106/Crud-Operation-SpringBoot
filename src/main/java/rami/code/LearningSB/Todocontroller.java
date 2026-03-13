package rami.code.LearningSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rami.code.LearningSB.models.Todo;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class Todocontroller {
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
        String getTodo(){
        return "Todo";
    }

    //PathVariable
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id){
        try {
            Todo createTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(createTodo, HttpStatus.OK);
        }catch(RuntimeException exception){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    ResponseEntity<List<Todo>> getTodos() {
        return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/page")
     ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size) {
      return new ResponseEntity<>(todoService.getAllTodosPages(page, size), HttpStatus.OK);
    }


    @PostMapping("/create")
    ResponseEntity<Todo>createUser(@RequestBody Todo todo){
            Todo createTodo = todoService.createTodo(todo);
            return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo) {
       return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    Void DeleteTodoById(@PathVariable long id) {
        todoService.deleteTodoById(id);
        return null;
    }
}
package rami.code.LearningSB.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import rami.code.LearningSB.service.TodoService;
import rami.code.LearningSB.models.Todo;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class Todocontroller {
    private static final Logger log = LoggerFactory.getLogger(Todocontroller.class);

    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
        String getTodo(){
        return "Todo";
    }

    //PathVariable
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo Retrieved Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo was not found!")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id){
        try {
            Todo createTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(createTodo, HttpStatus.OK);
        }catch(RuntimeException exception){
            log.info("Error");
            log.warn("");
            log.error("", exception);
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
    public ResponseEntity<Todo> createUser(@RequestBody Todo todo){
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

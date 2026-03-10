package rami.code.LearningSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rami.code.LearningSB.models.Todo;

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
        return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK);
    }

    //Request Param
    @GetMapping
    String getTodoByIdParam(@RequestParam("todoId")long id){
        return "Todo with Id" + id;
    }

    @PostMapping("/create")
    ResponseEntity<Todo>createUser(@RequestBody Todo todo){
        try {
            Todo createTodo = todoService.createTodo(todo);
            return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
        }catch(RuntimeException exception){
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    String updateTodoById(@PathVariable long id) {
        return "Update Todo with Id" + id;
    }
    @DeleteMapping("/{id}")
    String DeleteTodoById(@PathVariable long id) {
        return "Delete Todo with Id" + id;
    }

}
package rami.code.LearningSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todo")
public class Todocontroller {
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
        String getTodo(){
          todoService.printTodos();
        return "Todo";
    }
    //PathVariable
    @GetMapping("/{id}")
    String getTodoById(@PathVariable long id){
        return "Todo with Id" + id;
    }

    //Request Param
    @GetMapping
    String getTodoByIdParam(@RequestParam("todoId")long id){
        return "Todo with Id" + id;
    }
    @PostMapping("/create")
    String createUser(@RequestBody String body){
        return body;
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
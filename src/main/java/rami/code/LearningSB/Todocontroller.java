package rami.code.LearningSB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Todocontroller {
    @GetMapping("/todo/get")
        String getTodo(){
            return "Todo";
    }
    @GetMapping("/todo/id")
    String getTodoById(){
        return "Todo with Id";
    }
}

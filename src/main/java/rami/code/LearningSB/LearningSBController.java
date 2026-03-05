package rami.code.LearningSB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearningSBController {
    @GetMapping("/hello")
    String sayLearningSB(){
        return "Hello World!";
    }
}

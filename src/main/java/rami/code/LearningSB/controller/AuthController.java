package rami.code.LearningSB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rami.code.LearningSB.repository.UserRepository;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");
        if(userRepository.findByEmail(email).isPresent()){
           return new ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> body){

    }
}

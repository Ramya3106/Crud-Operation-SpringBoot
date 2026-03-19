package rami.code.LearningSB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rami.code.LearningSB.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rami.code.LearningSB.repository.UserRepository;
import rami.code.LearningSB.service.UserService;
import rami.code.LearningSB.utils.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserService userService,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = passwordEncoder.encode(body.get("password"));

        if(userRepository.findByEmail(email).isPresent()){
           return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        userService.createUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<>("Successfully Registered", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            return new ResponseEntity<>("User not Registered", HttpStatus.UNAUTHORIZED);
        }
        User user = userOptional.get();
        if(!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generatetoken(email);
        return ResponseEntity.ok(Map.of("token", token));
    }
}

package rami.code.LearningSB.utils;


import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class JwtUtil {
    private final String SECERT = "code io";
    private final long EXPIRATION = 1000*60;
    private final Key secertKey = Keys.hmacShaKeyFor(SECERT.getBytes(StandardCharsets.UTF_8));
}

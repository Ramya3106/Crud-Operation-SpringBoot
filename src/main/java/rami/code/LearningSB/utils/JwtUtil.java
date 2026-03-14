package rami.code.LearningSB.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECERT = "code io";
    private final long EXPIRATION = 1000*60;
    private final Key secertKey = Keys.hmacShaKeyFor(SECERT.getBytes(StandardCharsets.UTF_8));

    public String generatetoken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secertKey, SignatureAlgorithm.HS256)
                .compact();
    }
}
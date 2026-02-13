package com.example.security_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
@SpringBootApplication
public class SecurityPracticeApplication {

    public static void main(String[] args) {
        byte[] key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512).getEncoded();
        System.out.println("key: "+Base64.getEncoder().encodeToString(key));
        SpringApplication.run(SecurityPracticeApplication.class, args);
    }

}

//package com.example.jsp_ecommerce.service;
//
//
////import com.example.spring_security.model.Users;
//import com.example.jsp_ecommerce.entity.Users;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    private static final String SECRET_KEY =
//            "dGhpcy1pcy1hLXN1cGVyLXNlY3JldC1rZXktMzItYnl0ZXM=";
//
////    public JwtService(){
////        try {
////            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
////            SecretKey sk = keyGen.generateKey();
////            SECRET_KEY = Base64.getEncoder().encodeToString(sk.getEncoded());
////        } catch (NoSuchAlgorithmException e) {
////            throw new RuntimeException(e);
////        }
////    }
//
//    public String generateToken(String username, String role) {
////        Map<String, Object> claims = new HashMap<>();
//        return Jwts.builder()
//                .subject(username)
//                .claim("role", role)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7))
//                .signWith(getKey())   // 👈 NO algorithm param
//                .compact();
//    }
//
//    private SecretKey getKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String extractUsername(String token) {
//        // extract the username from jwt token
//        return extractClaim(token, Claims::getSubject);
//    }
//
//
//    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//
////    private Claims extractAllClaims(String token) {
////        return Jwts.parser()
////                .verifyWith(getKey())
////                .build()
////                .parseSignedClaims(token)
////                .getPayload();
////    }
//
//    public Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(getKey())      // 👈 NEW in 0.12.x
//                .build()
//                .parseSignedClaims(token)  // 👈 NEW in 0.12.x
//                .getPayload();             // 👈 returns Claims
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        final String userName = extractUsername(token);
//        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser()
//                    .setSigningKey(getKey()) // must return Key, not String
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public String extractRole(String token) {
//        return extractAllClaims(token).get("role", String.class);
//    }
//
//
//}

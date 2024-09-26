package com.example.jwttokendecode.demojwttokendecode;
/*import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    @Value("${jwt.secret}") // Your secret key from application properties
    private String secretKey;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public Claims decodeToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // Use the new method to set the key
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}*/



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private static final String SECRET_KEY = "c2VjdXJlc2FtcGxlc2VjcmV0a2V5Zm9yamp3dHNpZ25pbmcxMjM0NTY3ODk="; // Ensure it's a 256-bit secret

    // Validate and decode JWT token
    public Map<String, Object> decodeToken(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        // Parse the JWT token and get the claims
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Store claims in a Map and return it
        Map<String, Object> decodedClaims = new HashMap<>();
        decodedClaims.put("subject", claims.getSubject());
        decodedClaims.put("issuer", claims.getIssuer());
        decodedClaims.put("expiration", claims.getExpiration());
        decodedClaims.put("issuedAt", claims.getIssuedAt());
        decodedClaims.put("otherClaims", claims);  // You can also add all claims if needed

        return decodedClaims;
    }
}

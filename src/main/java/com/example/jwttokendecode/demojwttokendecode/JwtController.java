package com.example.jwttokendecode.demojwttokendecode;

/*import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/decode-token")
    public Claims decodeToken(@RequestParam String token) {
        return jwtUtil.decodeToken(token);
    }
}
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    // Endpoint to decode an existing JWT token
    @GetMapping("/decode")
    public Map<String, Object> decodeJwtToken(@RequestParam String token) {
        return jwtUtil.decodeToken(token);
    }
}




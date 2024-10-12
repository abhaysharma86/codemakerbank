package com.codemakerbank.controller;

import com.codemakerbank.ApplicationContext;
import com.codemakerbank.models.UserDOT;
import com.codemakerbank.models.UserLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserTokenController {

    private final AuthenticationManager authenticationManager;
    private final Environment environment;


    @RequestMapping("/user")
    public String getUserDetailsAfterLogin(Authentication authentication) {
//        Optional<UserLogin> optionalCustomer = customerRepository.findByEmail(authentication.getName());
        return "Test";
    }

    @PostMapping("/apiLogin")
    public ResponseEntity<UserDOT> apiLogin(@RequestBody UserDOT userDOT)
    {
        String jwt = "";
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(userDOT.name(), userDOT.password());
        Authentication authenticateResponse = authenticationManager.authenticate(authentication);
        if(authenticateResponse != null && authenticateResponse.isAuthenticated()){
            if(environment != null){
                String secret = environment.getProperty(ApplicationContext.JWT_SECRET_KEY, ApplicationContext.JWT_SECRET_DEFAULT_VALUE);
                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                jwt = Jwts.builder().issuer("Code Maker Bank").subject("JWT Token")
                        .claim("username", authenticateResponse.getName())
                        .claim("authorities", authenticateResponse.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                        .issuedAt(new Date())
                        .expiration(new Date(new Date().getTime() + 30000000))
                        .signWith(secretKey).compact();
            }
        }
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationContext.JWT_HEADER,jwt)
                .body(new UserDOT(HttpStatus.OK.getReasonPhrase(),jwt));
    }

}

package com.crveservices.crvservices.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.crveservices.crvservices.domain.employee.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generatedToken(Employee employee) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create().
                    withIssuer("login-auth-api").
                    withSubject(employee.getEmail()).
                    withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception) {
            throw new RuntimeException("Erro enquando estava autenticando");
        }

    }

    public String valid



    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
    }
}

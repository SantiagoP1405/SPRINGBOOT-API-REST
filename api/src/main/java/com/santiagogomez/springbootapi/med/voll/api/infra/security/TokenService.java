package com.santiagogomez.springbootapi.med.voll.api.infra.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {

    public String gerarToken() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456"); //ESTE TOKEN NORMALMENTE DEBE ESTAR OCULTO
            return JWT.create()
                .withIssuer("voll med")
                .withSubject("santiago.gomez")
                .sign(algorithm);
        } 
        catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
}

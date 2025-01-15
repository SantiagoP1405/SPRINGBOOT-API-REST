package com.santiagogomez.springbootapi.med.voll.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Inicio del filter");
        var token = request.getHeader("Authorization");
        System.out.println(token);
        if(token != null){
            System.out.println("Token no es null");
            token = token.replace("Bearer ", "");
            System.out.println(token);
            System.out.println(tokenService.getSubject(token));
        }
        filterChain.doFilter(request, response); //llama al siguiente filtro
    }
}
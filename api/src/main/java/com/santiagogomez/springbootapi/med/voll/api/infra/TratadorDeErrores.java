package com.santiagogomez.springbootapi.med.voll.api.infra;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;

@RestControllerAdvice //Actúa como proxy para interceptar llamadas en caso de que suceda una excepción 
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class) //Se encarga de manejar las excepciones
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

}

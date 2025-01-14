package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico(@RequestBody String parametro) {
        System.out.println("El request llega correctamente ♥♠♣B");
        System.out.println(parametro);
    }   
}

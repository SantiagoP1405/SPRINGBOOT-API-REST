package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico() {
        System.out.println("El request llega correctamente ♥♠♣B");
    }   
}

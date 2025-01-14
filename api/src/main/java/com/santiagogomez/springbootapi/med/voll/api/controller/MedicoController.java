package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

import com.santiagogomez.springbootapi.med.voll.api.medico.DatosRegistroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println(datosRegistroMedico);
    }   
}

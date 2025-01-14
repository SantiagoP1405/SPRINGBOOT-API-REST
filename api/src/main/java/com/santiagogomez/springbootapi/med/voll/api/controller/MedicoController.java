package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.santiagogomez.springbootapi.med.voll.api.medico.DatosRegistroMedico;
import com.santiagogomez.springbootapi.med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println(datosRegistroMedico);
    }   
}

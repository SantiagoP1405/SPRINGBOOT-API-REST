package com.santiagogomez.springbootapi.med.voll.api.controller;

import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.santiagogomez.springbootapi.med.voll.api.medico.DatosListadoMedico;
import com.santiagogomez.springbootapi.med.voll.api.medico.DatosRegistroMedico;
import com.santiagogomez.springbootapi.med.voll.api.medico.Medico;
import com.santiagogomez.springbootapi.med.voll.api.medico.MedicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }   

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }
}

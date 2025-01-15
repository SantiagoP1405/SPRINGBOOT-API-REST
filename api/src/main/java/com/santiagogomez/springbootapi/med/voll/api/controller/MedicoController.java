package com.santiagogomez.springbootapi.med.voll.api.controller;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.santiagogomez.springbootapi.med.voll.api.medico.*;

import jakarta.transaction.Transactional;
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
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault()Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizaMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }
}

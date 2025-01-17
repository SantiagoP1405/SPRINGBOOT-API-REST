package com.santiagogomez.springbootapi.med.voll.api.domain.consulta;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones.*;
import com.santiagogomez.springbootapi.med.voll.api.domain.medico.Medico;
import com.santiagogomez.springbootapi.med.voll.api.domain.medico.MedicoRepository;
import com.santiagogomez.springbootapi.med.voll.api.domain.paciente.PacienteRepository;

@Service
public class ReservaDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;
    
    @Autowired
    private List<ValidadorDeConsultas> validadores;

    public DatosDetalleConsulta reservar(DatosReservaConsulta datos) {
        if (!pacienteRepository.existsById(datos.idPaciente())) {
            throw new ValidacionException("El paciente no existe con ese id");
        }

        if (datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())) {
            throw new ValidacionException("El medico no existe con ese id");
        }

        validadores.forEach(v -> v.validar(datos)); //SE EJECUTAN TODOS LOS VALIDADORES QUE IMPLEMENTAN LA INTERFAZ

        var medico = elegirMedico(datos);

        if (medico == null) {
            throw new ValidacionException("No existe un médico disponible en ese horario");
        }

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);
    }
        
        
    private Medico elegirMedico(DatosReservaConsulta datos) {
        if (datos.idMedico() != null) {
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if (datos.especialidad() == null) {
            throw new ValidacionException("La especialidad es requerida cuando no se elige un médico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(datos.especialidad(), datos.fecha());
    }
}

package com.santiagogomez.springbootapi.med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    

    public void reservar(DatosReservaConsulta datos) {
        var medico = medicoRepository.findById(datos.idMedico()).get();
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var consulta = new Consulta(null, medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
    }
}

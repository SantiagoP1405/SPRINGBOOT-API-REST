package com.santiagogomez.springbootapi.med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
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
    

    public void reservar(DatosReservaConsulta datos) {
        if (!pacienteRepository.existsById(datos.idPaciente())) {
            throw new ValidacionException("El paciente no existe con ese id");
        }

        if (datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())) {
            throw new ValidacionException("El medico no existe con ese id");
        }

        var medico = elegirMedico(datos);
                var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        
                var consulta = new Consulta(null, medico, paciente, datos.fecha());
                consultaRepository.save(consulta);
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

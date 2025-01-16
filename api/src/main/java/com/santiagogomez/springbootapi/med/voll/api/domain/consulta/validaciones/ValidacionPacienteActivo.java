package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.DatosReservaConsulta;
import com.santiagogomez.springbootapi.med.voll.api.domain.paciente.PacienteRepository;

public class ValidacionPacienteActivo {
    private PacienteRepository pacienteRepository;
    public void validar(DatosReservaConsulta datos) {
        var pacienteActivo = pacienteRepository.findActivoById(datos.idPaciente());
        if (!pacienteActivo) {
            throw new ValidacionException("La consulta no puede ser reservada con paciente que no está activo");
        }
    }
}

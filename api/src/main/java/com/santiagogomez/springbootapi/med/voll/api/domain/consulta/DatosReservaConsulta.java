package com.santiagogomez.springbootapi.med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import com.santiagogomez.springbootapi.med.voll.api.domain.medico.Especialidad;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DatosReservaConsulta(

    Long idMedico,
    @NotNull
    Long idPaciente,
    @NotNull
    @Future
    LocalDateTime fecha,
    Especialidad especialidad
) {
    
}

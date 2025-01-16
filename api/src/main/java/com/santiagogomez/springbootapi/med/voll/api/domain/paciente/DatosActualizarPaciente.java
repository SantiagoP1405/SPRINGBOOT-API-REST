package com.santiagogomez.springbootapi.med.voll.api.domain.paciente;

import com.santiagogomez.springbootapi.med.voll.api.domain.direccion.*;

import jakarta.validation.constraints.NotNull;


public record DatosActualizarPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion) {
}
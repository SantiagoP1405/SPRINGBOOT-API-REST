package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import com.santiagogomez.springbootapi.med.voll.api.domain.direccion.*;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {

}

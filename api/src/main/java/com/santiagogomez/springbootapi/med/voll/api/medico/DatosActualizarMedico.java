package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.direccion.*;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {

}

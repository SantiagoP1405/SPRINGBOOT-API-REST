package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.direccion.DatosDireccion;

import jakarta.validation.constraints.*;

public record DatosRegistroMedico(
    @NotNull 
    @NotBlank
    String nombre, 

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")// Para limitar los dígitos del documento
    String documento,

    @NotBlank
    Especialidad especialidad,

    @NotNull
    DatosDireccion direccion
    
    ) {
}

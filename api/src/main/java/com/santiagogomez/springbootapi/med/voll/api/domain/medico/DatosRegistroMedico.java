package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import com.santiagogomez.springbootapi.med.voll.api.domain.direccion.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DatosRegistroMedico(
    
    @NotBlank
    String nombre, 

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefono,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")// Para limitar los dígitos del documento
    String documento,

    @NotNull
    Especialidad especialidad,

    @NotNull
    @Valid
    DatosDireccion direccion
    
    ) {

}

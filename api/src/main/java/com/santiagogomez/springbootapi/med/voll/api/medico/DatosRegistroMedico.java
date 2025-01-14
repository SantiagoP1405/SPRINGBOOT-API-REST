package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.DatosDireccion;

public record DatosRegistroMedico(
    String nombre, 
    String email,
    String documento,
    Especialidad especialidad,
    DatosDireccion direccion
    
    ) {
}

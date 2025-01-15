package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.direccion.*;

public record DatosRespuestaMedico(
    Long id,
    String nombre,
    String email,
    String telefono,
    String documento,
    Especialidad especialidad,
    DatosDireccion direccion
) {

}

package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import com.santiagogomez.springbootapi.med.voll.api.domain.direccion.*;

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

package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

public record DatosListadoMedico(

    Long id,

    String nombre, 

    String email,

    String telefono,

    String documento,

    Especialidad especialidad
) {

    public DatosListadoMedico(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getEspecialidad());
    }
} 


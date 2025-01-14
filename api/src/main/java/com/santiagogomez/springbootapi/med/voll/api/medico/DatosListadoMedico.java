package com.santiagogomez.springbootapi.med.voll.api.medico;

public record DatosListadoMedico(

    String nombre, 

    String email,

    String telefono,

    String documento,

    Especialidad especialidad
) {

    public DatosListadoMedico(Medico medico) {
        this(medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getEspecialidad());
    }
} 


package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.DatosReservaConsulta;
import com.santiagogomez.springbootapi.med.voll.api.domain.medico.*;

public class ValidacionMedicoActivo {
    private MedicoRepository medicoRepository;
    public void validar(DatosReservaConsulta datos) {
        if (datos.idMedico() == null) {
            return;
            
        }
        var medicoActivo = medicoRepository.findActivoById(datos.idMedico());
        if (!medicoActivo) {
            throw new ValidacionException("La consulta no puede ser reservada con médico que no está activo en el sistema");
        }
    }
}

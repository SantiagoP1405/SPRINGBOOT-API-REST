package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Component
public class ValidacionMedicoConOtraConsultaEnElMismoHorario implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DatosReservaConsulta datos) {
        var medicoTieneOtraConsultaEnElMismoHorario = consultaRepository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
        if (medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("El médico ya tiene una consulta reservada para este horario");    
        }
    }

}

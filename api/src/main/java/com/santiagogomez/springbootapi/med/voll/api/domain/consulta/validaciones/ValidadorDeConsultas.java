package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.DatosReservaConsulta;

public interface ValidadorDeConsultas {
    void validar(DatosReservaConsulta datos);
}

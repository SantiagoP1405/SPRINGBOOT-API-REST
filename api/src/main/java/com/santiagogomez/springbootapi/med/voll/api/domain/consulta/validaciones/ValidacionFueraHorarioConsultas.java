package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import java.time.*;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidacionFueraHorarioConsultas {
    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY); //VER IS ES DOMINGO
        var horarioAntesDeApertura = fechaConsulta.getHour() < 7; //VER SI ES ANTES DE LAS 7
        var horarioDespuesDeCierre = fechaConsulta.getHour() > 18; //VER SI ES DESPUES DE LAS 18 (6 PM)
        if (domingo || horarioAntesDeApertura || horarioDespuesDeCierre) {
            throw new ValidacionException("El horario sseleccionado está fuera del horario de atención");
        }
    }
}

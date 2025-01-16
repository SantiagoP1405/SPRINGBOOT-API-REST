package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.*;

public class ValidacionPacientesSinOtraConsultaElMismoDia {
    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaElMismoDia = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if (pacienteTieneOtraConsultaElMismoDia) {
            throw new ValidacionException("El paciente ya tiene una consulta reservada para este día");
        }
    }
}

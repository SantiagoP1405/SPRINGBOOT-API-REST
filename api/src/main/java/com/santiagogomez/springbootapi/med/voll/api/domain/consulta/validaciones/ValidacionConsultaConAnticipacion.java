package com.santiagogomez.springbootapi.med.voll.api.domain.consulta.validaciones;

import java.time.*;

import org.springframework.stereotype.*;

import com.santiagogomez.springbootapi.med.voll.api.domain.ValidacionException;
import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.*;

@Component
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas{
    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if (diferenciaEnMinutos < 30) {
            throw new ValidacionException("La consulta debe ser solicitada con al menos 30 minutos de anticipación");
            
        }
    }
}

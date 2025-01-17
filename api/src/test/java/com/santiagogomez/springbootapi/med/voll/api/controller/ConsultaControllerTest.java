package com.santiagogomez.springbootapi.med.voll.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;

import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.*;
import com.santiagogomez.springbootapi.med.voll.api.domain.medico.Especialidad;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DatosReservaConsulta> datosReservaJson;

    @Autowired
    private JacksonTester<DatosDetalleConsulta> datosDetalleJson;

    @MockBean
    private ReservaDeConsultas reservaDeConsultas;

    @Test
    @DisplayName("Debería devolver http 400 cuando la request no tiene datos")
    @WithMockUser //Simula un usuario autenticado
    void reservar_escenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
            .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        
    }

    @Test
    @DisplayName("Debería devolver http 200 cuando la request reciba un json válido")
    @WithMockUser //Simula un usuario autenticado
    void reservar_escenario2() throws Exception {
        var fecha = LocalDateTime.now().plusHours(1);
        var especialidad = Especialidad.CARDIOLOGIA;
        var datosDetalle = new DatosDetalleConsulta(null, 2L, 9L, fecha);
        when(reservaDeConsultas.reservar(any())).thenReturn(datosDetalle);

        var response = mvc.perform(post("/consultas")
            .contentType(MediaType.APPLICATION_JSON)//le estoy diciendo que voy a mandar un json
            .content(datosReservaJson.write(new DatosReservaConsulta(2L, 9L, fecha, especialidad)
            ).getJson()
            )
            ) 
            .andReturn().getResponse();
        var jsonEsperado = datosDetalleJson.write(
            datosDetalle
            ).getJson();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
        
    }
}

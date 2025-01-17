package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

import javax.swing.text.html.parser.Entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    private EntityManager em;

    @Test
    @DisplayName("Debería devolver null cuando el médico buscado no está disponible en esa fecha")
    void testElegirMedicoAleatorioDisponibleEnLaFechaEscenario1() {
        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

        var medico = 
        var paciente = 
        var consulta = 

        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);

        assertThat(medicoLibre).isNull();
    }
}

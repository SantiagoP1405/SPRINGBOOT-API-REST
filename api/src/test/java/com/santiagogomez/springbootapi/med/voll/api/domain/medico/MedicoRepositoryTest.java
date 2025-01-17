package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import java.time.*;
import java.time.temporal.*;

import javax.swing.text.html.parser.Entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.santiagogomez.springbootapi.med.voll.api.domain.consulta.*;
import com.santiagogomez.springbootapi.med.voll.api.domain.direccion.DatosDireccion;
import com.santiagogomez.springbootapi.med.voll.api.domain.paciente.*;

import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Debería devolver null cuando el médico buscado no está disponible en esa fecha")
    void testElegirMedicoAleatorioDisponibleEnLaFechaEscenario1() {
        //given o arrange
        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

        var medico = registrarMedico("Medico1", "medico@gmail.com", "12345", Especialidad.CARDIOLOGIA);
        var paciente = registrarPaciente("Paciente 1", "paciente@gmail.com", "123456");
        registrarConsulta(medico, paciente, lunesSiguienteALas10);
       
        //when o act
        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);
        //then o assert
        assertThat(medicoLibre).isNull();
    }

    @Test
    @DisplayName("Debería devolver medico cuando el médico buscado está disponible en esa fecha")
    void testElegirMedicoAleatorioDisponibleEnLaFechaEscenario2() {
        //given o arrange
        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

        var medico = registrarMedico("Medico1", "medico@gmail.com", "12345", Especialidad.CARDIOLOGIA);
        //when o act
        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);
        //then o assert
        assertThat(medicoLibre).isEqualTo(medico);
    }

    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha));
    }

    private Medico registrarMedico(String nombre, String email, String documento, Especialidad especialidad) {
       var medico = new Medico(datosMedico(nombre, email, documento, especialidad));
       em.persist(medico);
       return medico;
    }

    private Paciente registrarPaciente(String nombre, String email, String documento) {
        var paciente = new Paciente(datosPaciente(nombre, email, documento));
        em.persist(paciente);
        return paciente;
    }

    private DatosRegistroMedico datosMedico(String nombre, String email, String documento, Especialidad especialidad){
        return new DatosRegistroMedico(
            nombre,
            email,
            "2265523699",
            documento,
            especialidad,
            datosDireccion()
        );
    }

    private DatosRegistroPaciente datosPaciente(String nombre, String email, String documento) {
        return new DatosRegistroPaciente(
            nombre,
            email,
            "2265523699",
            documento,
            datosDireccion()
            );
    }

    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
            "Calle 123",
            "Distrito 123",
            "Ciudad 123",
            "123",
            "Complemento 123"
            );
    }


}

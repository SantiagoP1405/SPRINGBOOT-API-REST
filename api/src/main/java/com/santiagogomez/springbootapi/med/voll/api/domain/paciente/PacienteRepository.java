package com.santiagogomez.springbootapi.med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.NotNull;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT p.activo
            FROM Paciente p
            WHERE
            p.id = :idPaciente
            """)
    boolean findActivoById(Long idPaciente);
}
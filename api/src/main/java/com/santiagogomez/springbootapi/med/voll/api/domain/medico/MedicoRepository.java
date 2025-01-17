package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findByActivoTrue(Pageable paginacion); /*Parámetros, el tipo de objeto que se va a guardar, y el tipo de dato del id*/

    @Query("""
            SELECT m FROM Medico m
            WHERE 
            m.activo = TRUE
            AND 
            m.especialidad = :especialidad
            AND m.id NOT IN (
                SELECT c.medico.id FROM Consulta c
                WHERE
                c.fecha = :fecha
            )
            ORDER BY RAND()
            LIMIT 1
            """) 
    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
            SELECT m.activo
            FROM Medico m
            WHERE
            m.id = :idMedico
            """)
    boolean findActivoById(Long idMedico);
    
}

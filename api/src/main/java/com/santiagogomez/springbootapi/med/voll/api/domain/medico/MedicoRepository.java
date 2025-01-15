package com.santiagogomez.springbootapi.med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findByActivoTrue(Pageable paginacion); /*Parámetros, el tipo de objeto que se va a guardar, y el tipo de dato del id*/
    
}

package com.santiagogomez.springbootapi.med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> { /*Parámetros, el tipo de objeto que se va a guardar, y el tipo de dato del id*/
    
}

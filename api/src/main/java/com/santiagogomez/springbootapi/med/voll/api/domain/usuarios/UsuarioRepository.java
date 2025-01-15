package com.santiagogomez.springbootapi.med.voll.api.domain.usuarios;

import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByUsername(String username);
    

}

package com.santiagogomez.springbootapi.med.voll.api.domain.usuarios;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter // Lombok genera todas las funciones getter
@NoArgsConstructor // Lombok genera un constructor vacío
@AllArgsConstructor // Lombok genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;

}

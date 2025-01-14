package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.direccion.Direccion;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter // Lombok genera todas las funciones getter
@NoArgsConstructor // Lombok genera un constructor vacío
@AllArgsConstructor // Lombok genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") // Lombok genera las funciones equals y hashCode
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }
}

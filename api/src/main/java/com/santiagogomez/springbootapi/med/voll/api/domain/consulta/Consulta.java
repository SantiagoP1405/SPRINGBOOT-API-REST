package com.santiagogomez.springbootapi.med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import com.santiagogomez.springbootapi.med.voll.api.domain.medico.*;
import com.santiagogomez.springbootapi.med.voll.api.domain.paciente.*;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime fecha;

}

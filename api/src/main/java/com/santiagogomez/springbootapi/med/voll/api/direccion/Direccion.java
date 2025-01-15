package com.santiagogomez.springbootapi.med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter // Lombok genera todas las funciones getter
@NoArgsConstructor // Lombok genera un constructor vacío
@AllArgsConstructor // Lombok genera un constructor con todos los argumentos
public class Direccion {
    
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;
    
    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        return this;
    }
    
}

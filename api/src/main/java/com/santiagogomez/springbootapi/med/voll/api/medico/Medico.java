package com.santiagogomez.springbootapi.med.voll.api.medico;

import com.santiagogomez.springbootapi.med.voll.api.direccion.Direccion;

public class Medico {
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    private Especialidad especialidad;
    private Direccion direccion;

    public Medico(String nombre, String email, String documento, Especialidad especialidad, DatosDireccion direccion) {
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.especialidad = especialidad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public DatosDireccion getDireccion() {
        return direccion;
    }
}

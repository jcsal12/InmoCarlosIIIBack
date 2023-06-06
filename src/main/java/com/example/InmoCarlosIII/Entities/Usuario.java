package com.example.InmoCarlosIII.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private  String nombre;
    @Column
    private String email;
    @Column
    private String usuario;
    @Column
    private String clave;
    @Column
    private String telefono;


    //Relaciones
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Propiedad> propiedad = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contrato = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {

        this.clave = new BCryptPasswordEncoder().encode(clave);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Propiedad> getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(List<Propiedad> propiedad) {
        this.propiedad = propiedad;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }
}
package com.example.InmoCarlosIII.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private  String nombre;
    @Column
    private String apellidos;
    @Column
    private String DNI;
    @Column
    private String email;
    @Column
    private String usuario;
    @Column
    private String clave;
    @Column
    private String telefono;
    @Column
    private String direccion;

    //Relaciones
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Propiedad> propiedad = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contrato = new ArrayList<>();


}
package com.example.InmoCarlosIII.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String tipo;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private String precio;
    @Column
    private String detalles;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "propiedad_id")
    private Propiedad propiedad;


}

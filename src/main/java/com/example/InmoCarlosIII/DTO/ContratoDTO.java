package com.example.InmoCarlosIII.DTO;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {

    private String tipo;

    private Date fechaInicio;

    private Date fechaFin;

    private String precio;

    private String detalles;
}

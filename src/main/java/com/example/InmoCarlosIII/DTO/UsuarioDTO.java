package com.example.InmoCarlosIII.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nombre;

    private String apellidos;

    private String DNI;

    private String email;

    private String usuario;

    private String clave;

    private String telefono;

    private String direccion;

}

package com.example.InmoCarlosIII.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String email;

    private String clave;

    private String usuario;

    private String telefono;


}

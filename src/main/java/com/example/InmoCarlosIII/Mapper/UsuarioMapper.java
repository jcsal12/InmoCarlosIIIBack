package com.example.InmoCarlosIII.Mapper;

import com.example.InmoCarlosIII.DTO.UsuarioDTO;
import com.example.InmoCarlosIII.Entities.Usuario;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

   Usuario toEntity(UsuarioDTO usuarioDTO);
   UsuarioDTO toDTO(Usuario usuario);

}

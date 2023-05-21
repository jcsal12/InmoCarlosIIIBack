package com.example.InmoCarlosIII.Mapper;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Entities.Propiedad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropiedadMapper {

    PropiedadDTO toDTO(Propiedad propiedad);

    Propiedad toEntity(PropiedadDTO propiedadDTO);
}

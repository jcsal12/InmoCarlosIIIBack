package com.example.InmoCarlosIII.Mapper;


import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Entities.Contrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    ContratoDTO toDTO(Contrato contrato);

    Contrato toEntity(ContratoDTO contratoDTO);
}


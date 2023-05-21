package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Entities.Propiedad;
import com.example.InmoCarlosIII.Mapper.PropiedadMapper;
import com.example.InmoCarlosIII.Repositories.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    @Autowired
    private PropiedadMapper propiedadMapper;

    public PropiedadDTO createPropiedad(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad savedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(savedPropiedad);
    }

    public List<PropiedadDTO> getAllPropiedades() {
        return propiedadRepository.findAll().stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropiedadDTO getPropiedadById(Integer id) {
        return propiedadMapper.toDTO(propiedadRepository.findById(id).orElse(null));
    }

    public PropiedadDTO updatePropiedad(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad updatedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(updatedPropiedad);
    }

    public void deletePropiedad(Integer id) {
        propiedadRepository.deleteById(id);
    }
}

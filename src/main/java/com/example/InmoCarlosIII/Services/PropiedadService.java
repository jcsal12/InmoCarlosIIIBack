package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Entities.Propiedad;
import com.example.InmoCarlosIII.Repositories.PropiedadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    public List<PropiedadDTO> listarPropiedades(){
        return propiedadRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public PropiedadDTO listarPropiedadPorId(Integer id){
        Propiedad propiedad = propiedadRepository.findById(id).orElse(null);
        return propiedad != null ? convertToDto(propiedad) : null;
    }

    public PropiedadDTO crearPropiedad(PropiedadDTO propiedadDto){
        Propiedad propiedad = convertToEntity(propiedadDto);
        return convertToDto(propiedadRepository.save(propiedad));
    }

    public void borrarPropiedad(Integer id){
        propiedadRepository.deleteById(id);
    }

    public Optional<PropiedadDTO> actualizarPropiedad(Integer id, PropiedadDTO propiedadDto) {
        Optional<Propiedad> propiedadExistente = propiedadRepository.findById(id);
        if (propiedadExistente.isPresent()) {
            Propiedad propiedad = propiedadExistente.get();
            propiedad.setProvincia(propiedadDto.getProvincia());
            propiedad.setMunicipio(propiedadDto.getMunicipio());
            propiedad.setDireccion(propiedadDto.getDireccion());
            propiedad.setPrecio(propiedadDto.getPrecio());
            propiedad.setTipo(propiedadDto.getTipo());
            propiedad.setHabitaciones(propiedadDto.getHabitaciones());
            propiedad.setBanyos(propiedadDto.getBanyos());
            propiedad.setSuperficie(propiedadDto.getSuperficie());
            propiedad.setEstado(propiedadDto.getEstado());
            propiedad.setImagenes(propiedadDto.getImagenes());
            Propiedad propiedadActualizada = propiedadRepository.save(propiedad);
            return Optional.of(convertToDto(propiedadActualizada));
        } else {
            return Optional.empty();
        }
    }

    private PropiedadDTO convertToDto(Propiedad propiedad) {
        PropiedadDTO propiedadDto = new PropiedadDTO();
        propiedadDto.setProvincia(propiedad.getProvincia());
        propiedadDto.setMunicipio(propiedad.getMunicipio());
        propiedadDto.setDireccion(propiedad.getDireccion());
        propiedadDto.setPrecio(propiedad.getPrecio());
        propiedadDto.setTipo(propiedad.getTipo());
        propiedadDto.setHabitaciones(propiedad.getHabitaciones());
        propiedadDto.setBanyos(propiedad.getBanyos());
        propiedadDto.setSuperficie(propiedad.getSuperficie());
        propiedadDto.setEstado(propiedad.getEstado());
        propiedadDto.setImagenes(propiedad.getImagenes());
        return propiedadDto;
    }

    private Propiedad convertToEntity(PropiedadDTO propiedadDto) {
        Propiedad propiedad = new Propiedad();
        propiedad.setProvincia(propiedadDto.getProvincia());
        propiedad.setMunicipio(propiedadDto.getMunicipio());
        propiedad.setDireccion(propiedadDto.getDireccion());
        propiedad.setPrecio(propiedadDto.getPrecio());
        propiedad.setTipo(propiedadDto.getTipo());
        propiedad.setHabitaciones(propiedadDto.getHabitaciones());
        propiedad.setBanyos(propiedadDto.getBanyos());
        propiedad.setSuperficie(propiedadDto.getSuperficie());
        propiedad.setEstado(propiedadDto.getEstado());
        propiedad.setImagenes(propiedadDto.getImagenes());
        return propiedad;
    }

}

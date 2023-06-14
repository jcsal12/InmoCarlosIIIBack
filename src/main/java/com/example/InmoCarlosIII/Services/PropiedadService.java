package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Entities.Propiedad;
import com.example.InmoCarlosIII.Repositories.PropiedadRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    //faker
    private final Faker faker = new Faker();


    public PropiedadDTO getPropiedad(Long id) {
        Propiedad propiedad = propiedadRepository.findById(id).orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
        return convertToDTO(propiedad);
    }
    public List<PropiedadDTO> getAllPropiedades() {
        List<Propiedad> propiedades = propiedadRepository.findAll();
        return propiedades.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PropiedadDTO createPropiedad(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = convertToEntity(propiedadDTO);
        Propiedad savedPropiedad = propiedadRepository.save(propiedad);
        return convertToDTO(savedPropiedad);
    }

    public PropiedadDTO updatePropiedad(Long id, PropiedadDTO propiedadDTO) {
        Propiedad propiedad = propiedadRepository.findById(id).orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        propiedad.setId(propiedadDTO.getId());
        propiedad.setProvincia(propiedadDTO.getProvincia());
        propiedad.setMunicipio(propiedadDTO.getMunicipio());
        propiedad.setDireccion(propiedadDTO.getDireccion());
        propiedad.setPrecio(propiedadDTO.getPrecio());
        propiedad.setTipo(propiedadDTO.getTipo());
        propiedad.setHabitaciones(propiedadDTO.getHabitaciones());
        propiedad.setBanyos(propiedadDTO.getBanyos());
        propiedad.setSuperficie(propiedadDTO.getSuperficie());
        propiedad.setEstado(propiedadDTO.getEstado());
        propiedad.setImagenes(propiedadDTO.getImagenes());
        propiedad.setDescripcion(propiedadDTO.getDescripcion());

        Propiedad updatedPropiedad = propiedadRepository.save(propiedad);
        return convertToDTO(updatedPropiedad);
    }

    public void deletePropiedad(Long id) {
        if (!propiedadRepository.existsById(id)) {
            throw new RuntimeException("Propiedad no encontrada");
        }

        propiedadRepository.deleteById(id);
    }


    //FAKER
    public void generarDatosFicticios(int cantidad) {
        List<PropiedadDTO> propiedadesFicticias = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            PropiedadDTO propiedad = new PropiedadDTO();
            propiedad.setProvincia(faker.address().state());
            propiedad.setMunicipio(faker.address().city());
            propiedad.setDireccion(faker.address().streetAddress());
            propiedad.setPrecio(faker.number().randomDouble(2, 100000, 1000000));
            propiedad.setTipo(faker.lorem().word());
            propiedad.setHabitaciones(String.valueOf(faker.number().numberBetween(1, 6)));
            propiedad.setBanyos(String.valueOf(faker.number().numberBetween(1, 4)));
            propiedad.setSuperficie(String.valueOf(faker.number().numberBetween(50, 200)));
            propiedad.setEstado(faker.lorem().word());
            propiedad.setImagenes(faker.lorem().sentence());
            propiedad.setDescripcion(faker.lorem().paragraph());

            propiedadesFicticias.add(propiedad);
        }

        List<Propiedad> propiedadesGuardadas = propiedadRepository.saveAll(convertToEntityList(propiedadesFicticias));
        // Puedes realizar otras operaciones con las propiedades guardadas, si es necesario
    }


    // Conversion methods

    private PropiedadDTO convertToDTO(Propiedad propiedad) {
        PropiedadDTO propiedadDTO = new PropiedadDTO();

        propiedadDTO.setId(propiedad.getId());
        propiedadDTO.setProvincia(propiedad.getProvincia());
        propiedadDTO.setMunicipio(propiedad.getMunicipio());
        propiedadDTO.setDireccion(propiedad.getDireccion());
        propiedadDTO.setPrecio(propiedad.getPrecio());
        propiedadDTO.setTipo(propiedad.getTipo());
        propiedadDTO.setHabitaciones(propiedad.getHabitaciones());
        propiedadDTO.setBanyos(propiedad.getBanyos());
        propiedadDTO.setSuperficie(propiedad.getSuperficie());
        propiedadDTO.setEstado(propiedad.getEstado());
        propiedadDTO.setImagenes(propiedad.getImagenes());
        propiedadDTO.setDescripcion(propiedad.getDescripcion());

        return propiedadDTO;
    }

    private Propiedad convertToEntity(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = new Propiedad();

        propiedad.setId(propiedadDTO.getId());
        propiedad.setProvincia(propiedadDTO.getProvincia());
        propiedad.setMunicipio(propiedadDTO.getMunicipio());
        propiedad.setDireccion(propiedadDTO.getDireccion());
        propiedad.setPrecio(propiedadDTO.getPrecio());
        propiedad.setTipo(propiedadDTO.getTipo());
        propiedad.setHabitaciones(propiedadDTO.getHabitaciones());
        propiedad.setBanyos(propiedadDTO.getBanyos());
        propiedad.setSuperficie(propiedadDTO.getSuperficie());
        propiedad.setEstado(propiedadDTO.getEstado());
        propiedad.setImagenes(propiedadDTO.getImagenes());
        propiedad.setDescripcion(propiedadDTO.getDescripcion());

        return propiedad;
    }
    private List<Propiedad> convertToEntityList(List<PropiedadDTO> propiedadDTOList) {
        List<Propiedad> propiedadList = new ArrayList<>();

        for (PropiedadDTO propiedadDTO : propiedadDTOList) {
            Propiedad propiedad = new Propiedad();

            propiedad.setId(propiedadDTO.getId());
            propiedad.setProvincia(propiedadDTO.getProvincia());
            propiedad.setMunicipio(propiedadDTO.getMunicipio());
            propiedad.setDireccion(propiedadDTO.getDireccion());
            propiedad.setPrecio(propiedadDTO.getPrecio());
            propiedad.setTipo(propiedadDTO.getTipo());
            propiedad.setHabitaciones(propiedadDTO.getHabitaciones());
            propiedad.setBanyos(propiedadDTO.getBanyos());
            propiedad.setSuperficie(propiedadDTO.getSuperficie());
            propiedad.setEstado(propiedadDTO.getEstado());
            propiedad.setImagenes(propiedadDTO.getImagenes());
            propiedad.setDescripcion(propiedadDTO.getDescripcion());

            propiedadList.add(propiedad);
        }

        return propiedadList;
    }

}


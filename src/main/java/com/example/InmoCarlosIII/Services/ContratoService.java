package com.example.InmoCarlosIII.Services;


import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Entities.Contrato;
import com.example.InmoCarlosIII.Repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<ContratoDTO> listarContratos(){
        return contratoRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ContratoDTO listarContratoPorId(Integer id){
        Contrato contrato = contratoRepository.findById(id).orElse(null);
        return contrato != null ? convertToDto(contrato) : null;
    }

    public ContratoDTO crearContrato(ContratoDTO contratoDto){
        Contrato contrato = convertToEntity(contratoDto);
        Contrato savedContrato = contratoRepository.save(contrato);
        return convertToDto(savedContrato);
    }

    public void borrarContrato(Integer id){
        contratoRepository.deleteById(id);
    }

    public Optional<ContratoDTO> actualizarContrato(Integer id, ContratoDTO contratoDto) {
        Optional<Contrato> contratoExistente = contratoRepository.findById(id);
        if (contratoExistente.isPresent()) {
            Contrato contrato = contratoExistente.get();

            contrato.setTipo(contratoDto.getTipo());
            contrato.setFechaInicio(contratoDto.getFechaInicio());
            contrato.setFechaFin(contratoDto.getFechaFin());
            contrato.setPrecio(contratoDto.getPrecio());
            contrato.setDetalles(contratoDto.getDetalles());

            Contrato contratoActualizado = contratoRepository.save(contrato);
            return Optional.of(convertToDto(contratoActualizado));
        } else {
            return Optional.empty();
        }
    }

    // Utilidad para convertir a DTO
    private ContratoDTO convertToDto(Contrato contrato) {
        return new ContratoDTO(
                contrato.getTipo(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getPrecio(),
                contrato.getDetalles()
        );
    }

    // Utilidad para convertir a Entidad
    private Contrato convertToEntity(ContratoDTO contratoDto) {
        return new Contrato(
                null,
                contratoDto.getTipo(),
                contratoDto.getFechaInicio(),
                contratoDto.getFechaFin(),
                contratoDto.getPrecio(),
                contratoDto.getDetalles(),
                null, // Aquí necesitarías establecer la propiedad Usuario y Propiedad, si las tienes
                null  // Aquí necesitarías establecer la propiedad Usuario y Propiedad, si las tienes
        );
    }
}

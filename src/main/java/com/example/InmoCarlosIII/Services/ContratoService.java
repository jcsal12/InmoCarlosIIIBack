package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.Entities.Contrato;
import com.example.InmoCarlosIII.Repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.InmoCarlosIII.DTO.ContratoDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public ContratoDTO getContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return convertToDTO(contrato);
    }

    public List<ContratoDTO> getAllContratos() {
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public ContratoDTO createContrato(ContratoDTO contratoDTO) {
        Contrato contrato = convertToEntity(contratoDTO);
        Contrato savedContrato = contratoRepository.save(contrato);
        return convertToDTO(savedContrato);
    }
    public ContratoDTO updateContrato(Long id, ContratoDTO contratoDTO) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        contrato.setId(contratoDTO.getId());
        contrato.setTipo(contratoDTO.getTipo());
        contrato.setFechaInicio(contratoDTO.getFechaInicio());
        contrato.setFechaFin(contratoDTO.getFechaFin());
        contrato.setPrecio(contratoDTO.getPrecio());
        contrato.setDetalles(contratoDTO.getDetalles());

        Contrato savedContrato = contratoRepository.save(contrato);
        return convertToDTO(savedContrato);
    }

    public void deleteContrato(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new RuntimeException("Contrato no encontrado");
        }

        contratoRepository.deleteById(id);
    }

    // Conversion methods

    private ContratoDTO convertToDTO(Contrato contrato) {
        ContratoDTO contratoDTO = new ContratoDTO();

        contratoDTO.setId(contrato.getId());
        contratoDTO.setTipo(contrato.getTipo());
        contratoDTO.setFechaInicio(contrato.getFechaInicio());
        contratoDTO.setFechaFin(contrato.getFechaFin());
        contratoDTO.setPrecio(contrato.getPrecio());
        contratoDTO.setDetalles(contrato.getDetalles());

        return contratoDTO;
    }

    private Contrato convertToEntity(ContratoDTO contratoDTO) {
        Contrato contrato = new Contrato();

        contrato.setId(contratoDTO.getId());
        contrato.setTipo(contratoDTO.getTipo());
        contrato.setFechaInicio(contratoDTO.getFechaInicio());
        contrato.setFechaFin(contratoDTO.getFechaFin());
        contrato.setPrecio(contratoDTO.getPrecio());
        contrato.setDetalles(contratoDTO.getDetalles());

        return contrato;
    }
}

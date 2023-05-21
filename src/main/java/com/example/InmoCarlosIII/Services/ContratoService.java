package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Entities.Contrato;
import com.example.InmoCarlosIII.Mapper.ContratoMapper;
import com.example.InmoCarlosIII.Repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ContratoMapper contratoMapper;

    public ContratoDTO createContrato(ContratoDTO contratoDTO) {
        Contrato contrato = contratoMapper.toEntity(contratoDTO);
        Contrato savedContrato = contratoRepository.save(contrato);
        return contratoMapper.toDTO(savedContrato);
    }

    public List<ContratoDTO> getAllContratos() {
        return contratoRepository.findAll().stream()
                .map(contratoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContratoDTO getContratoById(Integer id) {
        return contratoMapper.toDTO(contratoRepository.findById(id).orElse(null));
    }

    public ContratoDTO updateContrato(ContratoDTO contratoDTO) {
        Contrato contrato = contratoMapper.toEntity(contratoDTO);
        Contrato updatedContrato = contratoRepository.save(contrato);
        return contratoMapper.toDTO(updatedContrato);
    }

    public void deleteContrato(Integer id) {
        contratoRepository.deleteById(id);
    }
}

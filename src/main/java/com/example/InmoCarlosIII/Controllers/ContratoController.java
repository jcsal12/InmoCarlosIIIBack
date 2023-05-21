package com.example.InmoCarlosIII.Controllers;

import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<ContratoDTO> createContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO createdContrato = contratoService.createContrato(contratoDTO);
        return new ResponseEntity<>(createdContrato, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> getAllContratos() {
        List<ContratoDTO> contratos = contratoService.getAllContratos();
        return new ResponseEntity<>(contratos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoById(@PathVariable Integer id) {
        ContratoDTO contrato = contratoService.getContratoById(id);
        return contrato != null ? new ResponseEntity<>(contrato, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> updateContrato(@PathVariable Integer id, @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO updatedContrato = contratoService.updateContrato(contratoDTO);
        return updatedContrato != null ? new ResponseEntity<>(updatedContrato, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContrato(@PathVariable Integer id) {
        contratoService.deleteContrato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

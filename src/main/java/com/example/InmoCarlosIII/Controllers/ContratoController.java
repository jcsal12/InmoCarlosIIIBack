package com.example.InmoCarlosIII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Services.ContratoService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContrato(@PathVariable Long id) {
        try {
            ContratoDTO contratoDTO = contratoService.getContrato(id);
            return ResponseEntity.ok(contratoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> getAllContratos() {
        List<ContratoDTO> contratos = contratoService.getAllContratos();
        return ResponseEntity.ok(contratos);
    }


    @PostMapping
    public ResponseEntity<ContratoDTO> createContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO createdContratoDTO = contratoService.createContrato(contratoDTO);
        return ResponseEntity.ok(createdContratoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> updateContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        try {
            ContratoDTO updatedContratoDTO = contratoService.updateContrato(id, contratoDTO);
            return ResponseEntity.ok(updatedContratoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Long id) {
        try {
            contratoService.deleteContrato(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

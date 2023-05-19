package com.example.InmoCarlosIII.Controllers;


import com.example.InmoCarlosIII.DTO.ContratoDTO;
import com.example.InmoCarlosIII.Services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> getAllContratos() {
        List<ContratoDTO> contratos = contratoService.listarContratos();
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoById(@PathVariable Integer id) {
        ContratoDTO contrato = contratoService.listarContratoPorId(id);
        if (contrato != null) {
            return ResponseEntity.ok(contrato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> createContrato(@RequestBody ContratoDTO contrato) {
        ContratoDTO createdContrato = contratoService.crearContrato(contrato);
        return ResponseEntity.ok(createdContrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Integer id) {
        contratoService.borrarContrato(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> updateContrato(@PathVariable Integer id, @RequestBody ContratoDTO contrato) {
        Optional<ContratoDTO> contratoActualizado = contratoService.actualizarContrato(id, contrato);
        if (contratoActualizado.isPresent()) {
            return ResponseEntity.ok(contratoActualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

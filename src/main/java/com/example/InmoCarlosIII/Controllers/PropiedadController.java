package com.example.InmoCarlosIII.Controllers;


import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadDTO> getPropiedad(@PathVariable Long id) {
        try {
            PropiedadDTO propiedadDTO = propiedadService.getPropiedad(id);
            return ResponseEntity.ok(propiedadDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<PropiedadDTO>> getAllPropiedades() {
        List<PropiedadDTO> propiedades = propiedadService.getAllPropiedades();
        return ResponseEntity.ok(propiedades);
    }


    @PostMapping
    public ResponseEntity<PropiedadDTO> createPropiedad(@RequestBody PropiedadDTO propiedadDTO) {
        PropiedadDTO createdPropiedadDTO = propiedadService.createPropiedad(propiedadDTO);
        return ResponseEntity.ok(createdPropiedadDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadDTO> updatePropiedad(@PathVariable Long id, @RequestBody PropiedadDTO propiedadDTO) {
        try {
            PropiedadDTO updatedPropiedadDTO = propiedadService.updatePropiedad(id, propiedadDTO);
            return ResponseEntity.ok(updatedPropiedadDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropiedad(@PathVariable Long id) {
        try {
            propiedadService.deletePropiedad(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/generarDatos/{cantidad}")
    public String generarDatosFicticios(@PathVariable int cantidad) {
        propiedadService.generarDatosFicticios(cantidad);
        return "Datos ficticios generados exitosamente.";
    }
}
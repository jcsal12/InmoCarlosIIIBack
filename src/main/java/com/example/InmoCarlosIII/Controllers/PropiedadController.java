package com.example.InmoCarlosIII.Controllers;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @PostMapping
    public ResponseEntity<PropiedadDTO> createPropiedad(@RequestBody PropiedadDTO propiedadDTO) {
        PropiedadDTO createdPropiedad = propiedadService.createPropiedad(propiedadDTO);
        return new ResponseEntity<>(createdPropiedad, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropiedadDTO>> getAllPropiedades() {
        List<PropiedadDTO> propiedades = propiedadService.getAllPropiedades();
        return new ResponseEntity<>(propiedades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadDTO> getPropiedadById(@PathVariable Integer id) {
        PropiedadDTO propiedad = propiedadService.getPropiedadById(id);
        return propiedad != null ? new ResponseEntity<>(propiedad, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadDTO> updatePropiedad(@PathVariable Integer id, @RequestBody PropiedadDTO propiedadDTO) {
        PropiedadDTO updatedPropiedad = propiedadService.updatePropiedad(propiedadDTO);
        return updatedPropiedad != null ? new ResponseEntity<>(updatedPropiedad, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePropiedad(@PathVariable Integer id) {
        propiedadService.deletePropiedad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

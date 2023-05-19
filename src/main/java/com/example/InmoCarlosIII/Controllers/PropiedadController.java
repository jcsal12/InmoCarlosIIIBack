package com.example.InmoCarlosIII.Controllers;

import com.example.InmoCarlosIII.DTO.PropiedadDTO;
import com.example.InmoCarlosIII.Services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @GetMapping
    public ResponseEntity<List<PropiedadDTO>> listarPropiedades() {
        return ResponseEntity.ok(propiedadService.listarPropiedades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadDTO> listarPropiedadPorId(@PathVariable Integer id) {
        PropiedadDTO propiedadDto = propiedadService.listarPropiedadPorId(id);
        if(propiedadDto == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(propiedadDto);
        }
    }

    @PostMapping
    public ResponseEntity<PropiedadDTO> crearPropiedad(@RequestBody PropiedadDTO propiedadDto) {
        PropiedadDTO nuevaPropiedadDto = propiedadService.crearPropiedad(propiedadDto);
        return ResponseEntity.ok(nuevaPropiedadDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPropiedad(@PathVariable Integer id) {
        propiedadService.borrarPropiedad(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadDTO> actualizarPropiedad(@PathVariable Integer id, @RequestBody PropiedadDTO propiedadDto) {
        Optional<PropiedadDTO> propiedadActualizada = propiedadService.actualizarPropiedad(id, propiedadDto);
        return propiedadActualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

package com.example.InmoCarlosIII.Controllers;

import com.example.InmoCarlosIII.DTO.UsuarioDTO;
import com.example.InmoCarlosIII.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> listarUsuarioPorId(@PathVariable Integer id){
        UsuarioDTO usuarioDto = usuarioService.listarUsuarioPorId(id);
        if (usuarioDto != null) {
            return ResponseEntity.ok(usuarioDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDto){
        return usuarioService.crearUsuario(usuarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Integer id){
        usuarioService.borrarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDto) {
        Optional<UsuarioDTO> usuarioDtoOptional = usuarioService.actualizarUsuario(id, usuarioDto);
        return usuarioDtoOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.example.InmoCarlosIII.Services;

import com.example.InmoCarlosIII.DTO.UsuarioDTO;
import com.example.InmoCarlosIII.Entities.Usuario;
import com.example.InmoCarlosIII.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO listarUsuarioPorId(Integer id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            return convertToDto(usuario);
        } else {
            return null;
        }
    }

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDto){
        Usuario usuario = convertToEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return convertToDto(usuarioGuardado);
    }

    public void borrarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioDTO> actualizarUsuario(Integer id, UsuarioDTO usuarioDto) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            usuario.setNombre(usuarioDto.getNombre());
            usuario.setApellidos(usuarioDto.getApellidos());
            usuario.setDNI(usuarioDto.getDNI());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setUsuario(usuario.getUsuario());
            usuario.setClave(usuario.getClave());
            usuario.setTelefono(usuarioDto.getTelefono());
            usuario.setDireccion(usuarioDto.getDireccion());

            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            return Optional.of(convertToDto(usuarioActualizado));
        } else {
            return Optional.empty();
        }
    }

    private UsuarioDTO convertToDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getDNI(),
                usuario.getEmail(),
                usuario.getUsuario(),
                usuario.getClave(),
                usuario.getTelefono(),
                usuario.getDireccion()
        );
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setDNI(usuarioDto.getDNI());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setClave(usuarioDto.getClave());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setDireccion(usuarioDto.getDireccion());
        return usuario;
    }

}

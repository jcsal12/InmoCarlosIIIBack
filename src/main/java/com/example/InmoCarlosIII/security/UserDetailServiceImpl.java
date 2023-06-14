package com.example.InmoCarlosIII.security;

import com.example.InmoCarlosIII.Entities.Usuario;
import com.example.InmoCarlosIII.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepositorio;
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario usuario1 = usuarioRepositorio
                .findOneByUsuario(usuario)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con user " + usuario + " no ha sido encontrado"));
        return new UserDetailsImpl(usuario1);
    }
}

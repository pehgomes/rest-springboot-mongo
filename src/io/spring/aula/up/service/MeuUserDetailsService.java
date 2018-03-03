package io.spring.aula.up.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.aula.up.config.MyUserDetails;
import io.spring.aula.up.entity.Usuario;
import io.spring.aula.up.repository.UsuarioRepository;

@Service
public class MeuUserDetailsService implements UserDetailsService {

	@Autowired
    private UsuarioRepository userRepository;

    @Autowired
    public MeuUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario nao existe!", username));
        }
        return new MyUserDetails(usuario);
    }
}

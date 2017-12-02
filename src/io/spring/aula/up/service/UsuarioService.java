package io.spring.aula.up.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.aula.up.entity.Usuario;

@Service
public class UsuarioService {

	public List<Usuario> listaUsuario(Usuario usuarioAdd) {
        List<Usuario> usuarioLista = new ArrayList<>();

        Usuario usuario = new Usuario();

        usuario.setEmail("pedrogomesup2@gmail.com");
        usuario.setIdade(21);
        usuario.setNome("Pedro");

        usuarioLista.add(usuario);

        usuario = new Usuario();

        usuario.setEmail("fulano@gmail.com");
        usuario.setIdade(35);
        usuario.setNome("Fulano de tal");

        usuarioLista.add(usuario);
        usuarioLista.add(usuarioAdd);

        return usuarioLista;
	}

	public List<Usuario> listaUsuario() {
        List<Usuario> usuarioLista = new ArrayList<>();

        Usuario usuario = new Usuario();

        usuario.setEmail("pedrogomesup2@gmail.com");
        usuario.setIdade(21);
        usuario.setNome("Pedro");

        usuarioLista.add(usuario);

        usuario = new Usuario();

        usuario.setEmail("jennycandido@gmail.com");
        usuario.setIdade(18);
        usuario.setNome("Jenny");

        usuarioLista.add(usuario);

        return usuarioLista;

	}

}

package io.spring.aula.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.up.entity.Usuario;
import io.spring.aula.up.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listUsuario() {
		return this.usuarioService.listaUsuario();
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public List<Usuario> listUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.listaUsuario(usuario);
	}
}

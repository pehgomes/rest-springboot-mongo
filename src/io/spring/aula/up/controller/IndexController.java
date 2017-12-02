package io.spring.aula.up.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.up.entity.Usuario;

@RestController
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTexto() {
		return "ola mundo - spring boot";
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public Usuario getTexto(@PathVariable String nome) {
		Usuario usuario = new Usuario(nome);
		return usuario;
	}
}

package io.spring.aula.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.up.entity.Perfil;
import io.spring.aula.up.service.PerfilService;

@RestController
public class PerfilController {
	
	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listPerfil() {
		return this.perfilService.listaPerfil();
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil listPerfil(@RequestBody Perfil perfil) {
		return this.perfilService.salvaPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editarPerfil(@RequestBody Perfil perfil) {
		return this.perfilService.salvaPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void excluirPerfil(@PathVariable String id) {
		this.perfilService.deletarPerfil(id);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil consultarPerfilPorId(@PathVariable String id) {
		return this.perfilService.buscarPerfilPorId(id);
	}
	
	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count) {
		return this.perfilService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/perfil/{nome}/nome", method = RequestMethod.GET)
    public List<Perfil> listaPaginada(@PathVariable String nome) {
        return this.perfilService.buscarPorNome(nome);
}


}

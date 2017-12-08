package io.spring.aula.up.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.aula.up.entity.Usuario;
import io.spring.aula.up.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
	}

	public Usuario salvaUsuario(Usuario usuarioAdd) {
		return usuarioRepository.save(usuarioAdd);
	}
	
	public void deletarUsuario(String id){
		usuarioRepository.delete(id);
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		return usuarioRepository.findOne(id);
	}
	
	/**
	 *@param count quantos registros desejar dentro da pagina
	 *@param page em qual pagina deseja estar
	 **/
	public Page<Usuario> listaPaginada(int count, int page) {
		Pageable pages = new PageRequest(page, count);
		return usuarioRepository.findAll(pages);
	}
	
	public List<Usuario> buscarPorNome(String nome) {
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}
	
}

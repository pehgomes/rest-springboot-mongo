package io.spring.aula.up.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.spring.aula.up.entity.Perfil;
import io.spring.aula.up.entity.Usuario;
import io.spring.aula.up.repository.PerfilRepository;
import io.spring.aula.up.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {

		List<Perfil> perfis = perfilRepository.findAll();

		if (perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));
			perfilRepository.save(new Perfil("ROLE_OREIA"));

			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

			List<Perfil> novosPerfis = new ArrayList<>();

			novosPerfis.add(perfil);

			usuarioRepository.save(new Usuario("ADMIN", "admin", "123", novosPerfis));

		}

	}

}

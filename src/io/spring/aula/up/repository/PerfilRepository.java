package io.spring.aula.up.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.up.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

	public List<Perfil> findByNomeLikeIgnoreCase(String nome);

	public Perfil findByNome(String string);

	public Perfil save(Perfil perfil);
}

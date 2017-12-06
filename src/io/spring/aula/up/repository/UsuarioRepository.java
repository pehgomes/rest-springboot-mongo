package io.spring.aula.up.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.up.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}

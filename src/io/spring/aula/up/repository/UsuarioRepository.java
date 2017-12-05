package io.spring.aula.up.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.up.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Serializable> {

}

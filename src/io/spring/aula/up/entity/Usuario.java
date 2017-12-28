package io.spring.aula.up.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {

	@Id
	private String id;

	private String nome;

	private String email;

	private String senha; 
	/**
	 * Utilizado para fazer relacionamentos entre documentos, aqui um
	 * {@link Usuario} pode possuir um ou muitos {@link List}{@link Perfil}
	 **/
	@DBRef
	private List<Perfil> perfis;
	
	private int idade;


	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario() {
	}

	public Usuario(String string, String string2, String string3, List<Perfil> novosPerfis) {
	}

	public Usuario(Usuario usuario) {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}

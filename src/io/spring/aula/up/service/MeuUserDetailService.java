package io.spring.aula.up.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.spring.aula.up.entity.Usuario;
import io.spring.aula.up.repository.UsuarioRepository;

public class MeuUserDetailService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public MeuUserDetailService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		;
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario nao existe", usuario));
		}

		return new UserRepositoryUserDetails(usuario);
	}

	private final static class UserRepositoryUserDetails extends Usuario implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(Usuario usuario) {
			super(usuario);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return (Collection<? extends GrantedAuthority>) getPerfis();
		}

		@Override
		public String getPassword() {
			return getPassword();
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}

}

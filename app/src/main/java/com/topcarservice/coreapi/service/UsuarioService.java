package com.topcarservice.coreapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.Usuario;
import com.topcarservice.coreapi.repository.UsuarioRepository;
import com.topcarservice.coreapi.service.mapper.UsuarioDetailsMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepo;
	
	private final UsuarioDetailsMapper usuarioMapper;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		
		Usuario usuario = usuarioRepo.findByLogin(username);
		return usuarioMapper.convertUsuario(usuario);		 
	}	

}

package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.Cliente;
import com.topcarservice.coreapi.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);		
	}

	public Cliente carregar(Long codigo) {
		
		return clienteRepository.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);		
	}

}

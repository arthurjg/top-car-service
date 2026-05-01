package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.Servico;
import com.topcarservice.coreapi.repository.ServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicoService {
	
	private final ServicoRepository servicoRepository;

	public void salvar(Servico servico) {
		servicoRepository.save(servico);		
	}

	public Servico carregar(Long codigo) {
		
		return servicoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Servico não encontrado"));
	}

	public void excluir(Servico servico) {
		servicoRepository.delete(servico);		
	}

}

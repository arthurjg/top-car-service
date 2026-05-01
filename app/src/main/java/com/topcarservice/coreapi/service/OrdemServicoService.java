package com.topcarservice.coreapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.repository.OrdemServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdemServicoService {
	
	private final OrdemServicoRepository ordemServicoRepository;

	public OrdemServico salvar(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);		
	}

	public OrdemServico carregar(Long codigo) {
		
		return ordemServicoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrado"));
	}

	public void excluir(OrdemServico ordemServico) {
		ordemServicoRepository.delete(ordemServico);		
	}

	public List<OrdemServico> listar() {		
		return ordemServicoRepository.findAll();
	}

}

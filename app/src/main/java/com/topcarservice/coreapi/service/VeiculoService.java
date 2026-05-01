package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.Veiculo;
import com.topcarservice.coreapi.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VeiculoService {
	
	private final VeiculoRepository veiculoRepository;	

	public void salvar(Veiculo veiculo) {		
		veiculoRepository.save(veiculo);		
	}

	public Veiculo carregar(Long codigo) {
		
		return veiculoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado"));
	}

	public void excluir(Veiculo veiculo) {
		veiculoRepository.delete(veiculo);		
	}

}

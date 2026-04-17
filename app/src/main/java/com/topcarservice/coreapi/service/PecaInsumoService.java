package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.PecaInsumo;
import com.topcarservice.coreapi.repository.PecaInsumoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PecaInsumoService {
	
	private final PecaInsumoRepository pecaInsumoRepository;

	public void salvar(PecaInsumo pecaInsumo) {
		pecaInsumoRepository.save(pecaInsumo);		
	}

	public PecaInsumo carregar(Long codigo) {
		
		return pecaInsumoRepository.findById(codigo)
				.orElseThrow(() -> new RuntimeException("PecaInsumo não encontrado"));
	}

	public void excluir(PecaInsumo pecaInsumo) {
		pecaInsumoRepository.delete(pecaInsumo);		
	}

}

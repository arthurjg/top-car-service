package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.PecaInsumoSolicitado;
import com.topcarservice.coreapi.repository.PecaInsumoSolicitadoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PecaInsumoSolicitadoService {
	
	private final PecaInsumoSolicitadoRepository pecaInsumoSolicitadoRepository;

	public PecaInsumoSolicitado salvar(PecaInsumoSolicitado pecaInsumoSolicitado) {
		return pecaInsumoSolicitadoRepository.save(pecaInsumoSolicitado);		
	}	

}

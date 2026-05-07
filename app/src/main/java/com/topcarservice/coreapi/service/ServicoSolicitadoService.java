package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.ServicoSolicitado;
import com.topcarservice.coreapi.repository.ServicoSolicitadoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicoSolicitadoService {
	
	private final ServicoSolicitadoRepository servicoSolicitadoRepository;

	public ServicoSolicitado salvar(ServicoSolicitado servicoSolicitado) {
		return servicoSolicitadoRepository.save(servicoSolicitado);		
	}	

}

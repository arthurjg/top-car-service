package com.topcarservice.coreapi.adapters.presenters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.ServicoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.ServicoMapper;
import com.topcarservice.coreapi.domain.entities.Servico;
import com.topcarservice.coreapi.domain.usecases.ServicoUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/clientes")
public class ServicoPresenter {
	
	private final ServicoUseCase servicoUseCase;
	
	private final ServicoMapper servicoMapper;	
	
	@GetMapping("/{id}")
	public ResponseEntity<ServicoDTO> buscar(@PathVariable("id") Long codigo) {			
		
		try {
			Servico servico = servicoUseCase.carregar(codigo);	
			
			ServicoDTO servicoResponse = servicoMapper.mapTo(servico);
			
			return ResponseEntity.ok().body(servicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		}	
	}

}

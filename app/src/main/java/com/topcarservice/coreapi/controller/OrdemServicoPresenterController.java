package com.topcarservice.coreapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.controller.mapper.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.service.OrdemServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/public/ordem-servicos")
public class OrdemServicoPresenterController {
	
	OrdemServicoService ordemServicoService;		
	
	OrdemServicoMapper ordemServicoMapper;		
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoRetornoDTO> buscar(@PathVariable("id") Long codigo) {	
		
		try {
			OrdemServico ordemServico = ordemServicoService.carregar(codigo);	
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		}	
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoRetornoDTO>> listar() {	
		
		List<OrdemServico> ordemsServico = ordemServicoService.listar();	
		
		List<OrdemServicoRetornoDTO> ordemsServicoRetorno  = ordemServicoMapper.map(ordemsServico);
		
		return ResponseEntity.ok().body(ordemsServicoRetorno);
	}

}

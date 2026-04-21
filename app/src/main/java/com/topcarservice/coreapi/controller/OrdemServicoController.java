package com.topcarservice.coreapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.mapper.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.service.OrdemServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordemServicos")
public class OrdemServicoController {
	
	OrdemServicoService ordemServicoService;	
	
	OrdemServicoMapper ordemServicoMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody @Validated OrdemServicoDTO ordemServicoDto) throws Exception {		
		
		OrdemServico ordemServico = ordemServicoMapper.map(ordemServicoDto);		
		
		ordemServicoService.salvar(ordemServico);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable("id") Long codigo) {	
		
		OrdemServico ordemServico = ordemServicoService.carregar(codigo);		
		
		return ResponseEntity.ok().body(ordemServico);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServico>> listar() {	
		
		List<OrdemServico> ordemsServico = ordemServicoService.listar();		
		
		return ResponseEntity.ok().body(ordemsServico);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated OrdemServicoDTO ordemServicoDto) {	
		
		OrdemServico ordemServico = ordemServicoMapper.map(ordemServicoDto);		
		
		ordemServico.setCodigo(codigo);
		
		ordemServicoService.salvar(ordemServico);	
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		OrdemServico ordemServico = ordemServicoService.carregar(codigo);
		ordemServicoService.excluir(ordemServico);	
		
		return ResponseEntity.noContent().build();
	}

}

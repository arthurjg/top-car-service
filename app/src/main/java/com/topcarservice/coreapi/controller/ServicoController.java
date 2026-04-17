package com.topcarservice.coreapi.controller;

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

import com.topcarservice.coreapi.controller.dto.ServicoDTO;
import com.topcarservice.coreapi.controller.mapper.ServicoMapper;
import com.topcarservice.coreapi.domain.Servico;
import com.topcarservice.coreapi.service.ServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/servicos")
public class ServicoController {
	
	ServicoService servicoService;	
	
	ServicoMapper servicoMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody @Validated ServicoDTO servicoDto) throws Exception {		
		
		Servico servico = servicoMapper.map(servicoDto);		
		
		servicoService.salvar(servico);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> buscar(@PathVariable("id") Long codigo) {	
		
		Servico servico = servicoService.carregar(codigo);		
		
		return ResponseEntity.ok().body(servico);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated ServicoDTO servicoDto) {	
		
		Servico servico = servicoMapper.map(servicoDto);		
		
		servico.setCodigo(codigo);
		
		servicoService.salvar(servico);	
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		Servico servico = servicoService.carregar(codigo);
		servicoService.excluir(servico);	
		
		return ResponseEntity.noContent().build();
	}

}

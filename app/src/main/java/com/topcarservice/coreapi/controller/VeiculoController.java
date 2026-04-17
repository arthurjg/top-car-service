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

import com.topcarservice.coreapi.controller.dto.VeiculoDTO;
import com.topcarservice.coreapi.controller.mapper.VeiculoMapper;
import com.topcarservice.coreapi.domain.Veiculo;
import com.topcarservice.coreapi.service.VeiculoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	VeiculoService veiculoService;	
	
	VeiculoMapper veiculoMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody @Validated VeiculoDTO veiculoDto) throws Exception {		
		
		Veiculo veiculo = veiculoMapper.map(veiculoDto);		
		
		veiculoService.salvar(veiculo);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscar(@PathVariable("id") Long codigo) {	
		
		Veiculo veiculo = veiculoService.carregar(codigo);		
		
		return ResponseEntity.ok().body(veiculo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated VeiculoDTO veiculoDto) {	
		
		Veiculo veiculo = veiculoMapper.map(veiculoDto);		
		
		veiculo.setCodigo(codigo);
		
		veiculoService.salvar(veiculo);	
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		Veiculo veiculo = veiculoService.carregar(codigo);
		veiculoService.excluir(veiculo);	
		
		return ResponseEntity.noContent().build();
	}

}

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

import com.topcarservice.coreapi.controller.dto.PecaInsumoDTO;
import com.topcarservice.coreapi.controller.mapper.PecaInsumoMapper;
import com.topcarservice.coreapi.domain.PecaInsumo;
import com.topcarservice.coreapi.service.PecaInsumoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/peca-insumos")
public class PecaInsumoController {
	
	PecaInsumoService pecaInsumoService;	
	
	PecaInsumoMapper pecaInsumoMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody @Validated PecaInsumoDTO pecaInsumoDto) throws Exception {		
		
		PecaInsumo pecaInsumo = pecaInsumoMapper.map(pecaInsumoDto);		
		
		pecaInsumoService.salvar(pecaInsumo);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PecaInsumo> buscar(@PathVariable("id") Long codigo) {	
		
		PecaInsumo pecaInsumo = pecaInsumoService.carregar(codigo);		
		
		return ResponseEntity.ok().body(pecaInsumo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated PecaInsumoDTO pecaInsumoDto) {	
		
		PecaInsumo pecaInsumo = pecaInsumoMapper.map(pecaInsumoDto);		
		
		pecaInsumo.setCodigo(codigo);
		
		pecaInsumoService.salvar(pecaInsumo);	
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		PecaInsumo pecaInsumo = pecaInsumoService.carregar(codigo);
		pecaInsumoService.excluir(pecaInsumo);	
		
		return ResponseEntity.noContent().build();
	}

}

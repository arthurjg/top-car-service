package com.topcarservice.coreapi.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.ClienteDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.ClienteMapper;
import com.topcarservice.coreapi.domain.entities.Cliente;
import com.topcarservice.coreapi.domain.usecases.ClienteUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/clientes")
public class ClienteController {
	
	private final ClienteUseCase clienteUseCase;
	
	private final ClienteMapper clienteMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void cadastrar(@RequestBody @Validated ClienteDTO clienteDto) throws Exception {		
		
		Cliente cliente = clienteMapper.map(clienteDto);		
		
		clienteUseCase.cadastrar(cliente);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated ClienteDTO clienteDto) {	
		
		Cliente cliente = clienteMapper.map(clienteDto);		
		
		cliente.setCodigo(codigo);
		
		clienteUseCase.cadastrar(cliente);			
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		Cliente cliente = clienteUseCase.carregar(codigo);
		clienteUseCase.excluir(cliente);	
		
		return ResponseEntity.noContent().build();
	}

}

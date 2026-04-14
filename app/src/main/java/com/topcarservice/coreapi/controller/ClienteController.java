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

import com.topcarservice.coreapi.controller.dto.ClienteDTO;
import com.topcarservice.coreapi.controller.mapper.ClienteMapper;
import com.topcarservice.coreapi.domain.Cliente;
import com.topcarservice.coreapi.service.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	ClienteService clienteService;	
	
	ClienteMapper clienteMapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody @Validated ClienteDTO clienteDto) throws Exception {		
		
		Cliente cliente = clienteMapper.map(clienteDto);		
		
		clienteService.salvar(cliente);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable("id") Long codigo) {	
		
		Cliente cliente = clienteService.carregar(codigo);		
		
		return ResponseEntity.ok().body(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long codigo,
			@RequestBody @Validated ClienteDTO clienteDto) {	
		
		Cliente cliente = clienteMapper.map(clienteDto);		
		
		cliente.setCodigo(codigo);
		
		clienteService.salvar(cliente);	
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long codigo) {	
		
		Cliente cliente = clienteService.carregar(codigo);
		clienteService.excluir(cliente);	
		
		return ResponseEntity.noContent().build();
	}

}

package com.topcarservice.coreapi.adapters.presenters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.ClienteDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.ClienteMapper;
import com.topcarservice.coreapi.domain.entities.Cliente;
import com.topcarservice.coreapi.domain.usecases.ClienteUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/clientes")
public class ClientePresenter {
	
	private final ClienteUseCase clienteUseCase;
	
	private final ClienteMapper clienteMapper;	
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable("id") Long codigo) {		
				
		try {
			Cliente cliente = clienteUseCase.carregar(codigo);	
			ClienteDTO clienteDTO = clienteMapper.map(cliente);
			
			return ResponseEntity.ok().body(clienteDTO);
		} catch (IllegalArgumentException e) {			
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();
		}			
		
	}

}

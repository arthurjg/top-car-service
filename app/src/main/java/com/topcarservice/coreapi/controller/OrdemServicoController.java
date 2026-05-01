package com.topcarservice.coreapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.controller.mapper.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.Cliente;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.service.ClienteService;
import com.topcarservice.coreapi.service.OrdemServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordem-servicos")
public class OrdemServicoController {
	
	OrdemServicoService ordemServicoService;	
	
	ClienteService clienteService;
	
	OrdemServicoMapper ordemServicoMapper;	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated OrdemServicoDTO ordemServicoDto) {			
		
		try {
			Cliente cliente = clienteService.carregar(ordemServicoDto.getCodigoCliente());
			
			OrdemServico ordemServico = new OrdemServico(cliente);		
			
			var ordemServicoSalva =  ordemServicoService.salvar(ordemServico);
			return ResponseEntity.created(URI.create("/admin/ordem-servicos/" + ordemServicoSalva.getCodigo())).build();
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		}	
	}
	
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

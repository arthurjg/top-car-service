package com.topcarservice.coreapi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoItemSolicitadoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.controller.mapper.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.Cliente;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.domain.PecaInsumo;
import com.topcarservice.coreapi.domain.Servico;
import com.topcarservice.coreapi.service.ClienteService;
import com.topcarservice.coreapi.service.OrdemServicoService;
import com.topcarservice.coreapi.service.PecaInsumoService;
import com.topcarservice.coreapi.service.ServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordem-servicos")
public class OrdemServicoController {
	
	OrdemServicoService ordemServicoService;	
	
	ClienteService clienteService;
	
	ServicoService servicoService;
	
	PecaInsumoService pecaInsumoService;
	
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
	
	@PostMapping("/{id}/servicos")
	public ResponseEntity<OrdemServicoOrcamentoDTO> incluirServico(@PathVariable("id") Long codigo,
			@RequestBody @Validated OrdemServicoItemSolicitadoDTO ordemServicoSolicitadoDto) {	
		
		try {
			OrdemServico ordemServico = ordemServicoService.carregar(codigo);	
			
			Servico servico = servicoService.carregar(ordemServicoSolicitadoDto.getCodigoItem());
			
			OrdemServicoOrcamentoDTO orcamento = ordemServicoService.incluirServico(ordemServico, servico);
			return ResponseEntity.ok().body(orcamento);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}				
	}
	
	@PostMapping("/{id}/pecas-insumos")
	public ResponseEntity<OrdemServicoOrcamentoDTO> incluirPecaInsumo(@PathVariable("id") Long codigo,
			@RequestBody @Validated OrdemServicoItemSolicitadoDTO ordemServicoSolicitadoDto) {	
		
		try {
			OrdemServico ordemServico = ordemServicoService.carregar(codigo);	
			
			PecaInsumo pecaInsumo = pecaInsumoService.carregar(ordemServicoSolicitadoDto.getCodigoItem());
			
			OrdemServicoOrcamentoDTO orcamento = ordemServicoService.incluirPecaInsumo(ordemServico, pecaInsumo, ordemServicoSolicitadoDto.getQuantidade());
			return ResponseEntity.ok().body(orcamento);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}			
	}
	
	@PutMapping("/{id}/aprovacao")
	public ResponseEntity<OrdemServicoRetornoDTO> enviarAprovacao(@PathVariable("id") Long codigo) {			
		
		try {
			OrdemServico ordemServico = ordemServicoService.carregar(codigo);	
			
			ordemServicoService.enviarAprovacao(ordemServico);
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}	
	}

	

}

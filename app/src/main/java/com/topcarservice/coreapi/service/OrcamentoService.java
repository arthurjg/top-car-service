package com.topcarservice.coreapi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.controller.dto.OrcamentoItemDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.util.DateTimeUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrcamentoService {
	
	public OrdemServicoOrcamentoDTO gerarOrcamento(OrdemServico ordemServico) {		
		
		List<OrcamentoItemDTO> itens = new ArrayList<>();
		
		List<OrcamentoItemDTO> servicos = ordemServico.getServicos()
				.stream()
				.map(servicoSolicitado -> OrcamentoItemDTO.builder()
						.descricao(servicoSolicitado.getNome())
						.quantidade(1)
						.valorUnitario(servicoSolicitado.getValorMaoDeObra())
						.valorTotal(servicoSolicitado.getValorMaoDeObra())
						.build())
				.toList();		
		
		List<OrcamentoItemDTO> pecasInsumos = ordemServico.getPecasInsumos()
				.stream()
				.map(pecaInsumoSolicitado -> OrcamentoItemDTO.builder()
						.descricao(pecaInsumoSolicitado.getNome())
						.quantidade(pecaInsumoSolicitado.getQuantidade())
						.valorUnitario(pecaInsumoSolicitado.getValorUnitario())
						.valorTotal(pecaInsumoSolicitado.getValorTotal())
						.build())
				.toList();	
		
		itens.addAll(servicos);	
		itens.addAll(pecasInsumos);	
		
		return OrdemServicoOrcamentoDTO.builder()
				.codigoOrdemServico(ordemServico.getCodigo())
				.cliente(ordemServico.getCliente().getNome())
				.dataOrcamento(DateTimeUtil.formatarDataHora(LocalDateTime.now()))
				.itens(itens)
				.valorTotal(itens.stream()
						.map(OrcamentoItemDTO::getValorTotal)
						.reduce(BigDecimal.ZERO, BigDecimal::add))
				.build();
		
	}

}

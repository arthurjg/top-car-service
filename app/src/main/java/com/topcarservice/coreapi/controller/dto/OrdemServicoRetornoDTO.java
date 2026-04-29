package com.topcarservice.coreapi.controller.dto;

import java.util.List;

import com.topcarservice.coreapi.domain.StatusOrdemServico;

public record OrdemServicoRetornoDTO(Long codigo, String status, String nomeCliente, List<String> servicos, String dataAbertura) {
	
	public OrdemServicoRetornoDTO(Long codigo, StatusOrdemServico status, String nomeCliente, List<String> servicos, String dataAbertura) {
		this(codigo, status.name(), nomeCliente, servicos, dataAbertura);
	}

}

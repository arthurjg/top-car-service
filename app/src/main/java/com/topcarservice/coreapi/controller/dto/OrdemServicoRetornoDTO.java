package com.topcarservice.coreapi.controller.dto;

import java.util.List;

import com.topcarservice.coreapi.domain.StatusOrdemServico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoRetornoDTO{
	
	Long codigo;
	String status;
	String cliente;
	List<String> servicos;
	String dataAbertura;
	
	public OrdemServicoRetornoDTO(Long codigo, StatusOrdemServico status, String nomeCliente, List<String> servicos, String dataAbertura) {
		this(codigo, status.name(), nomeCliente, servicos, dataAbertura);
	}

}

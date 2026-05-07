package com.topcarservice.coreapi.controller.dto;

import java.util.List;

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
	List<OrdemServicoSolicitadoRetornoDTO> servicos;
	List<OrdemServicoPecaInsumoSolicitadoDTO> pecasInsumos;
	String dataAbertura;	

}

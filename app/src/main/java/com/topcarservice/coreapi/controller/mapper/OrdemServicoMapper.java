package com.topcarservice.coreapi.controller.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.util.DateTimeUtil;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrdemServico map(OrdemServicoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}
	
	public OrdemServicoRetornoDTO map(OrdemServico ordemServico) {		
		return OrdemServicoRetornoDTO.builder()
				.codigo(ordemServico.getCodigo())
				.status(ordemServico.getStatus().name())
				.cliente(ordemServico.getCliente().getNome())
				.dataAbertura(DateTimeUtil.formatarDataHora(ordemServico.getDataAbertura()))
				.build();
	}

	public List<OrdemServicoRetornoDTO> map(List<OrdemServico> ordemsServico) {		
		return ordemsServico.stream()
				.map(ordemServico -> map(ordemServico))
				.toList();
	}	

}

package com.topcarservice.coreapi.controller.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrdemServico map(OrdemServicoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}
	
	public OrdemServicoRetornoDTO map(OrdemServico ordemServico) {		
		return objectMapper.map(ordemServico, OrdemServicoRetornoDTO.class);
	}

	public List<OrdemServicoRetornoDTO> map(List<OrdemServico> ordemsServico) {		
		return ordemsServico.stream()
				.map(ordemServico -> map(ordemServico))
				.toList();
	}

}

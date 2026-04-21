package com.topcarservice.coreapi.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrdemServico map(OrdemServicoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}

}

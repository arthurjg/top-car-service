package com.topcarservice.coreapi.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.PecaInsumoDTO;
import com.topcarservice.coreapi.domain.PecaInsumo;

@Component
public class PecaInsumoMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public PecaInsumo map(PecaInsumoDTO pecaInsumoDto) {		
		return objectMapper.map(pecaInsumoDto, PecaInsumo.class);
	}

	public PecaInsumoDTO mapTo(PecaInsumo pecaInsumo) {
		return objectMapper.map(pecaInsumo, PecaInsumoDTO.class);
	}

}

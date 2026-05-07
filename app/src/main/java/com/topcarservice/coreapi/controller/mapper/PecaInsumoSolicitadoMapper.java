package com.topcarservice.coreapi.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.OrdemServicoPecaInsumoSolicitadoDTO;
import com.topcarservice.coreapi.domain.PecaInsumoSolicitado;

@Component
public class PecaInsumoSolicitadoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	
	
	public OrdemServicoPecaInsumoSolicitadoDTO mapTo(PecaInsumoSolicitado pecaInsumo) {		
		return objectMapper.map(pecaInsumo, OrdemServicoPecaInsumoSolicitadoDTO.class);
	}

}

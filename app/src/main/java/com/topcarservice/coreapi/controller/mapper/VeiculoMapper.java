package com.topcarservice.coreapi.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.VeiculoDTO;
import com.topcarservice.coreapi.domain.Veiculo;

@Component
public class VeiculoMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public Veiculo map(VeiculoDTO veiculoDto) {		
		return objectMapper.map(veiculoDto, Veiculo.class);
	}

}

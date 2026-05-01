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
		return Veiculo.builder()
				.placa(veiculoDto.getPlaca())
				.marca(veiculoDto.getMarca())
				.modelo(veiculoDto.getModelo())
				.ano(veiculoDto.getAno())
				.build();
	}
	
	public VeiculoDTO mapTo(Veiculo veiculo) {		
		return VeiculoDTO.builder()
				.placa(veiculo.getPlaca())
				.marca(veiculo.getMarca())
				.modelo(veiculo.getModelo())
				.ano(veiculo.getAno())
				.codigoCliente(veiculo.getCliente().getCodigo())
				.build();
	}

}

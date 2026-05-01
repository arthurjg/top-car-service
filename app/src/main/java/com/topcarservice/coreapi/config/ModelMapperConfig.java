package com.topcarservice.coreapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topcarservice.coreapi.controller.dto.VeiculoDTO;
import com.topcarservice.coreapi.domain.Veiculo;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	ModelMapper modelMapper() {				
		var modelMapper = new ModelMapper();		
		
		return modelMapper;
	}

}

package com.topcarservice.coreapi.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.ClienteDTO;
import com.topcarservice.coreapi.domain.Cliente;

@Component
public class ClienteMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public Cliente map(ClienteDTO clienteDto) {		
		return objectMapper.map(clienteDto, Cliente.class);
	}

	public ClienteDTO map(Cliente cliente) {
		return objectMapper.map(cliente, ClienteDTO.class);
	}

}

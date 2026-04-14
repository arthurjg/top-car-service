package com.topcarservice.coreapi.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.Cliente;
import com.topcarservice.coreapi.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
	
	@InjectMocks
	ClienteService service;
	
	@Mock
	ClienteRepository	repository;

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testSalvar() {				
		
		Cliente cliente = Cliente.builder()
				.nome("John Doe")				
				.build();		
		
		service.salvar(cliente);
		
		verify(repository).save(cliente);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		Cliente clienteMock = Cliente.builder()
				.nome("John Doe")				
				.build();
		
		when(repository.findById(codigo)).thenReturn(Optional.of(clienteMock));
		
		Cliente clienteResult = service.carregar(codigo);
		
		assertNotNull(clienteResult);
		assertEquals(clienteMock.getNome(), clienteResult.getNome());
	}

	@Test
	void testExcluir() {
		Cliente cliente = Cliente.builder()
				.nome("John Doe")				
				.build();		
		
		service.excluir(cliente);
		
		verify(repository).delete(cliente);
	}

}

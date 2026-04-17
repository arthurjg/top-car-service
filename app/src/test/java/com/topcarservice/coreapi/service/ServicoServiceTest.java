package com.topcarservice.coreapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.Servico;
import com.topcarservice.coreapi.repository.ServicoRepository;

@ExtendWith(MockitoExtension.class)
class ServicoServiceTest {
	
	@InjectMocks
	ServicoService service;
	
	@Mock
	ServicoRepository	repository;	
	
	@Test
	void testSalvar() {				
		
		Servico servico = Servico.builder()
				.nome("John Doe")				
				.build();		
		
		service.salvar(servico);
		
		verify(repository).save(servico);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		Servico servicoMock = Servico.builder()
				.nome("John Doe")				
				.build();
		
		when(repository.findById(codigo)).thenReturn(Optional.of(servicoMock));
		
		Servico servicoResult = service.carregar(codigo);
		
		assertNotNull(servicoResult);
		assertEquals(servicoMock.getNome(), servicoResult.getNome());
	}

	@Test
	void testExcluir() {
		Servico servico = Servico.builder()
				.nome("John Doe")				
				.build();		
		
		service.excluir(servico);
		
		verify(repository).delete(servico);
	}

}

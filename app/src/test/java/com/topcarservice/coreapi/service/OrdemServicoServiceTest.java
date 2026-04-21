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

import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.repository.OrdemServicoRepository;

@ExtendWith(MockitoExtension.class)
class OrdemServicoServiceTest {
	
	@InjectMocks
	OrdemServicoService service;
	
	@Mock
	OrdemServicoRepository	repository;	
	
	@Test
	void testSalvar() {				
		
		OrdemServico ordemServico = OrdemServico.builder()
				.nome("John Doe")				
				.build();		
		
		service.salvar(ordemServico);
		
		verify(repository).save(ordemServico);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		OrdemServico ordemServicoMock = OrdemServico.builder()
				.nome("John Doe")				
				.build();
		
		when(repository.findById(codigo)).thenReturn(Optional.of(ordemServicoMock));
		
		OrdemServico ordemServicoResult = service.carregar(codigo);
		
		assertNotNull(ordemServicoResult);
		assertEquals(ordemServicoMock.getNome(), ordemServicoResult.getNome());
	}

	@Test
	void testExcluir() {
		OrdemServico ordemServico = OrdemServico.builder()
				.nome("John Doe")				
				.build();		
		
		service.excluir(ordemServico);
		
		verify(repository).delete(ordemServico);
	}

}

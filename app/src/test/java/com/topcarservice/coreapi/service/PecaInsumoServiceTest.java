package com.topcarservice.coreapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.PecaInsumo;
import com.topcarservice.coreapi.repository.PecaInsumoRepository;

@ExtendWith(MockitoExtension.class)
class PecaInsumoServiceTest {
	
	@InjectMocks
	PecaInsumoService service;
	
	@Mock
	PecaInsumoRepository	repository;	
	
	@Test
	void testSalvar() {				
		
		PecaInsumo pecaInsumo = PecaInsumo.builder()
				.nome("John Doe")				
				.build();		
		
		service.salvar(pecaInsumo);
		
		verify(repository).save(pecaInsumo);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		PecaInsumo pecaInsumoMock = PecaInsumo.builder()
				.nome("John Doe")				
				.build();
		
		when(repository.findById(codigo)).thenReturn(Optional.of(pecaInsumoMock));
		
		PecaInsumo pecaInsumoResult = service.carregar(codigo);
		
		assertNotNull(pecaInsumoResult);
		assertEquals(pecaInsumoMock.getNome(), pecaInsumoResult.getNome());
	}

	@Test
	void testExcluir() {
		PecaInsumo pecaInsumo = PecaInsumo.builder()
				.nome("John Doe")				
				.build();		
		
		service.excluir(pecaInsumo);
		
		verify(repository).delete(pecaInsumo);
	}

}

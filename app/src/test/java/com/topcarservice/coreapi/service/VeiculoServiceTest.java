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

import com.topcarservice.coreapi.domain.Veiculo;
import com.topcarservice.coreapi.repository.VeiculoRepository;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {
	
	@InjectMocks
	VeiculoService service;
	
	@Mock
	VeiculoRepository	repository;

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testSalvar() {				
		
		Veiculo veiculo = Veiculo.builder()
				.nome("John Doe")				
				.build();		
		
		service.salvar(veiculo);
		
		verify(repository).save(veiculo);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;
		
		Veiculo veiculoMock = Veiculo.builder()
				.nome("John Doe")				
				.build();
		
		when(repository.findById(codigo)).thenReturn(Optional.of(veiculoMock));
		
		Veiculo veiculoResult = service.carregar(codigo);
		
		assertNotNull(veiculoResult);
		assertEquals(veiculoMock.getNome(), veiculoResult.getNome());
	}

	@Test
	void testExcluir() {
		Veiculo veiculo = Veiculo.builder()
				.nome("John Doe")				
				.build();		
		
		service.excluir(veiculo);
		
		verify(repository).delete(veiculo);
	}

}

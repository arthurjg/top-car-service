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
	
	Veiculo veiculo;

	@BeforeEach
	void setUp() throws Exception {
		
		veiculo = Veiculo.builder()
				.placa("QHU-5R66")
				.marca("Porche")
				.modelo("Cayenne")
				.ano(2022)
				.build();	
	}
	
	@Test
	void testSalvar() {					
		
		service.salvar(veiculo);
		
		verify(repository).save(veiculo);
	}	

	@Test
	void testCarregar() {
		
		long codigo = 1L;		
		
		when(repository.findById(codigo)).thenReturn(Optional.of(veiculo));
		
		Veiculo veiculoResult = service.carregar(codigo);
		
		assertNotNull(veiculoResult);
		assertEquals(veiculo.getPlaca(), veiculoResult.getPlaca());
		assertEquals(veiculo.getMarca(), veiculoResult.getMarca());
		assertEquals(veiculo.getModelo(), veiculoResult.getModelo());
		assertEquals(veiculo.getAno(), veiculoResult.getAno());
	}

	@Test
	void testExcluir() {				
		
		service.excluir(veiculo);
		
		verify(repository).delete(veiculo);
	}

}

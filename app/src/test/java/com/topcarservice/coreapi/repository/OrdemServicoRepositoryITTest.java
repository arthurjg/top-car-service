package com.topcarservice.coreapi.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.topcarservice.coreapi.domain.OrdemServico;

@DataJpaTest
class OrdemServicoRepositoryITTest {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	OrdemServico ordemServico;

	@BeforeEach
	void setUp() throws Exception {
		
		ordemServico = new OrdemServico();
	}
	
	@Test
	void listaOrdemServico_ComCodigoValido_RetornaListaOrdemServico() {
		
		OrdemServico ordemServicoSalvo = entityManager.persist(ordemServico);		
		
		List<OrdemServico> ordemServicoListResultado  = ordemServicoRepository.findAll();		
		
		assertNotNull(ordemServicoListResultado);
		assertFalse(ordemServicoListResultado.isEmpty());
		assertTrue(ordemServicoListResultado.size() == 1);
		
		
	}

	/*
	 * @Test void criaOrdemServico_ComDadosValidos_RetornaOrdemServico() {
	 * 
	 * OrdemServico ordemServicoSalvo = ordemServicoRepository.save(ordemServico);
	 * 
	 * var ordemServicoResultado = entityManager.find(OrdemServico.class,
	 * ordemServicoSalvo.getCodigo());
	 * 
	 * assertNotNull(ordemServicoResultado);
	 * assertEquals(ordemServicoResultado.getPlaca(), ordemServico.getPlaca());
	 * assertEquals(ordemServicoResultado.getMarca(), ordemServico.getMarca());
	 * assertEquals(ordemServicoResultado.getModelo(), ordemServico.getModelo());
	 * assertEquals(ordemServicoResultado.getAno(), ordemServico.getAno()); }
	 */
	
	@Test
	void carregaOrdemServico_ComCodigoValido_RetornaOrdemServico() {
		
		OrdemServico ordemServicoSalvo = entityManager.persist(ordemServico);		
		
		Optional<OrdemServico> op = ordemServicoRepository.findById(ordemServicoSalvo.getCodigo());
		
		var ordemServicoResultado = entityManager.find(OrdemServico.class, ordemServicoSalvo.getCodigo());
		
		assertTrue(op.isPresent());
		assertNotNull(ordemServicoResultado);
		assertEquals(ordemServicoSalvo, ordemServicoResultado);
		
	}
	
	/*
	 * @Test void atualizaOrdemServico_ComCodigoValido_RetornaOrdemServico() {
	 * 
	 * OrdemServico ordemServicoSalvo = entityManager.persist(ordemServico);
	 * 
	 * ordemServicoSalvo = entityManager.find(OrdemServico.class,
	 * ordemServicoSalvo.getCodigo());
	 * 
	 * ordemServicoSalvo.setModelo("Cayenne S Plus");
	 * 
	 * var ordemServicoResultado = ordemServicoRepository.save(ordemServicoSalvo);
	 * 
	 * assertNotNull(ordemServicoResultado);
	 * assertEquals(ordemServicoSalvo.getModelo(),
	 * ordemServicoResultado.getModelo());
	 * 
	 * }
	 */
	
	

}

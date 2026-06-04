package com.topcarservice.coreapi.service;

/*
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertFalse; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import com.topcarservice.coreapi.domain.OrdemServico; import
 * com.topcarservice.coreapi.infra.db.entities.ClienteDBEntity; import
 * com.topcarservice.coreapi.repository.OrdemServicoRepository;
 * 
 * @ExtendWith(MockitoExtension.class) class OrdemServicoServiceTest {
 * 
 * @InjectMocks OrdemServicoService service;
 * 
 * @Mock OrdemServicoRepository repository;
 * 
 * private OrdemServico ordemServico;
 * 
 * @BeforeEach void setUp() throws Exception { var cliente =
 * ClienteDBEntity.builder() .codigo(999L) .cpf("05197324996") .nome("Artjoe")
 * .build();
 * 
 * ordemServico = new OrdemServico(cliente); }
 * 
 * @Test void testSalvar() {
 * 
 * service.salvar(ordemServico);
 * 
 * verify(repository).save(ordemServico); }
 * 
 * @Test void testCarregar() {
 * 
 * long codigo = 1L;
 * 
 * when(repository.findById(codigo)).thenReturn(Optional.of(ordemServico));
 * 
 * OrdemServico ordemServicoResult = service.carregar(codigo);
 * 
 * assertNotNull(ordemServicoResult);
 * assertEquals(ordemServico.getDataAbertura(),
 * ordemServicoResult.getDataAbertura()); assertEquals(ordemServico.getStatus(),
 * ordemServicoResult.getStatus()); assertEquals(ordemServico.getCliente(),
 * ordemServicoResult.getCliente()); }
 * 
 * @Test void testExcluir() {
 * 
 * service.excluir(ordemServico);
 * 
 * verify(repository).delete(ordemServico); }
 * 
 * @Test void testLitagem() {
 * 
 * when(repository.findAll()).thenReturn(List.of(ordemServico));
 * 
 * List<OrdemServico> ordemsServicosResult = service.listar();
 * 
 * assertNotNull(ordemsServicosResult);
 * assertFalse(ordemsServicosResult.isEmpty());
 * 
 * 
 * }
 * 
 * }
 */

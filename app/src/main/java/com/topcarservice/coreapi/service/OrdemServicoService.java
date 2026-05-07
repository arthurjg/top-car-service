package com.topcarservice.coreapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.controller.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.domain.PecaInsumo;
import com.topcarservice.coreapi.domain.PecaInsumoSolicitado;
import com.topcarservice.coreapi.domain.Servico;
import com.topcarservice.coreapi.domain.ServicoSolicitado;
import com.topcarservice.coreapi.domain.StatusOrdemServico;
import com.topcarservice.coreapi.repository.OrdemServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdemServicoService {
	
	private final OrdemServicoRepository ordemServicoRepository;
	
	private final ServicoSolicitadoService servicoSolicitadoService;
	
	private final PecaInsumoSolicitadoService pecaInsumoSolicitadoService;
	
	private final PecaInsumoService pecaInsumoService;
	
	private final OrcamentoService orcamentoService;
	
	private final AprovacaoService aprovacaoService;

	public OrdemServico salvar(OrdemServico ordemServico) {		
		
		return ordemServicoRepository.save(ordemServico);		
	}	
	
	/*
	 * public OrdemServico atualizar(OrdemServico ordemServico) {
	 * 
	 * salvar(ordemServico);
	 * 
	 * if(ordemServico.getStatus().equals(StatusOrdemServico.EM_DIAGNOSTICO)) {
	 * orcamentoService.gerarOrcamento(ordemServico); }
	 * 
	 * 
	 * }
	 */

	public OrdemServico carregar(Long codigo) {
		
		return ordemServicoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrado"));
	}

	public void excluir(OrdemServico ordemServico) {
		ordemServicoRepository.delete(ordemServico);		
	}

	public List<OrdemServico> listar() {		
		return ordemServicoRepository.findAll();
	}

	public OrdemServicoOrcamentoDTO incluirServico(OrdemServico ordemServico, Servico servico) {
		
		if( !(ordemServico.getStatus().equals(StatusOrdemServico.RECEBIDA) || ordemServico.getStatus().equals(StatusOrdemServico.EM_DIAGNOSTICO) )) {
			throw new IllegalStateException("Ordem de serviço já está fechada. Não é possível incluir novos serviços.");
		}		
		
		ServicoSolicitado servicoSolicitado = servicoSolicitadoService.salvar(new ServicoSolicitado(servico));
		
		ordemServico.getServicos().add(servicoSolicitado);
		
		if(ordemServico.getStatus().equals(StatusOrdemServico.RECEBIDA)) {
			ordemServico.setStatus(StatusOrdemServico.EM_DIAGNOSTICO);
		}
		
		salvar(ordemServico);	
		
		return orcamentoService.gerarOrcamento(ordemServico);
	}

	public OrdemServicoOrcamentoDTO incluirPecaInsumo(OrdemServico ordemServico, PecaInsumo pecaInsumo, Integer quantidade) {
		if( !(ordemServico.getStatus().equals(StatusOrdemServico.RECEBIDA) || ordemServico.getStatus().equals(StatusOrdemServico.EM_DIAGNOSTICO) )) {
			throw new IllegalStateException("Ordem de serviço já está fechada. Não é possível incluir novos serviços.");
		}		
		
		if(quantidade == 0 || quantidade > pecaInsumo.getQuantidade()) {
			throw new IllegalStateException("Quantidade solicitada é inválida. Não Pode ser maior do que a quantidade disponível em estoque, nem ser zero.");
		}
		
		pecaInsumo.setQuantidade(pecaInsumo.getQuantidade() - quantidade);
		
		pecaInsumoService.salvar(pecaInsumo);
		
		PecaInsumoSolicitado pecaInsumoSolicitado = pecaInsumoSolicitadoService.salvar(new PecaInsumoSolicitado(pecaInsumo, quantidade));
		
		ordemServico.getPecasInsumos().add(pecaInsumoSolicitado);
		
		if(ordemServico.getStatus().equals(StatusOrdemServico.RECEBIDA)) {
			ordemServico.setStatus(StatusOrdemServico.EM_DIAGNOSTICO);
		}
		
		salvar(ordemServico);	
		
		return orcamentoService.gerarOrcamento(ordemServico);
		
	}
	
	public OrdemServico enviarAprovacao(OrdemServico ordemServico) {
		
		
		if (!ordemServico.getStatus().equals(StatusOrdemServico.EM_DIAGNOSTICO)) {
			throw new IllegalStateException(
					"Ordem de serviço está num estado inválido. Não é possível enviar para aprovação.");
		}
		 
		 
		OrdemServicoOrcamentoDTO orcamento = orcamentoService.gerarOrcamento(ordemServico);
		 
		aprovacaoService.enviarAprovacaoOrdemServico(ordemServico, orcamento);
		 
		ordemServico.setStatus(StatusOrdemServico.AGUARDANDO_APROVACAO);
		 
		return salvar(ordemServico);		
	}
	
	

}

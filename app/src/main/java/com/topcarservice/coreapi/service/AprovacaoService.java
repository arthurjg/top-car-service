package com.topcarservice.coreapi.service;

import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.controller.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;

@Service
public class AprovacaoService {
	
	public void enviarAprovacaoOrdemServico(OrdemServico ordemServico, OrdemServicoOrcamentoDTO orcamento) {
		// Lógica para enviar o orçamento para aprovação, por exemplo, por email ou notificações
		
		System.out.println("Enviando orçamento para aprovação:");
		System.out.println(orcamento);
		
	}

}

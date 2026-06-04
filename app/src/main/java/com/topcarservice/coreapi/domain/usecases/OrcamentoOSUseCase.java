package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;


public class OrcamentoOSUseCase {
	
	private final OrdemServicoInputPort inputPort;
	private final OrdemServicoOutputPort outputPort;
	
	public OrcamentoOSUseCase(OrdemServicoInputPort inputPort, OrdemServicoOutputPort outputPort) {
		this.inputPort = inputPort;
		this.outputPort = outputPort;
	}

	public void cadastrar(OrdemServico ordemServico) {
		inputPort.save(ordemServico);		
	}

	public OrdemServico carregar(Long codigo) {
		
		return outputPort.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrado"));
	}

	public void excluir(OrdemServico ordemServico) {
		inputPort.delete(ordemServico);		
	}

}

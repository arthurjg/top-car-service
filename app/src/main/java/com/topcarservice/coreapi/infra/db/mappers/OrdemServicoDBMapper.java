package com.topcarservice.coreapi.infra.db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.infra.db.entities.OrdemServicoDBEntity;

@Component
public class OrdemServicoDBMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrdemServicoDBEntity map(OrdemServico ordemServico) {		
		return OrdemServicoDBEntity.builder()
				.codigo(ordemServico.getCodigo())
				.descricao(ordemServico.getDescricao())
				.valor(ordemServico.getValor())
				.build();
				//objectMapper.map(ordemServico, OrdemServicoDBEntity.class);
	}
	
	public OrdemServico mapTo(OrdemServicoDBEntity ordemServicoDBEntity) {		
		return objectMapper.map(ordemServicoDBEntity, OrdemServico.class);
	}

}

package com.topcarservice.coreapi.controller.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.controller.dto.OrdemServicoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoPecaInsumoSolicitadoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.controller.dto.OrdemServicoSolicitadoRetornoDTO;
import com.topcarservice.coreapi.domain.OrdemServico;
import com.topcarservice.coreapi.util.DateTimeUtil;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;
	
	@Autowired
	private ServicoSolicitadoMapper servicoSolicitadoMapper;
	
	@Autowired
	private PecaInsumoSolicitadoMapper pecaInsumoSolicitadoMapper;	

	public OrdemServico map(OrdemServicoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}
	
	public OrdemServicoRetornoDTO map(OrdemServico ordemServico) {			
		
		List<OrdemServicoSolicitadoRetornoDTO> servicosSolicitados = 
				ordemServico.getServicos()
				.stream()
				.map(servicoSolicitadoEntity -> servicoSolicitadoMapper.mapTo(servicoSolicitadoEntity))
				.toList();
		
		List<OrdemServicoPecaInsumoSolicitadoDTO> pecasInsumosSolicitados = 
				ordemServico.getPecasInsumos()
				.stream()
				.map(pecaInsumoSolicitado -> pecaInsumoSolicitadoMapper.mapTo(pecaInsumoSolicitado))
				.toList();
		
		return OrdemServicoRetornoDTO.builder()
				.codigo(ordemServico.getCodigo())
				.status(ordemServico.getStatus().name())
				.cliente(ordemServico.getCliente().getNome())
				.dataAbertura(DateTimeUtil.formatarDataHora(ordemServico.getDataAbertura()))
				.servicos(servicosSolicitados)
				.pecasInsumos(pecasInsumosSolicitados)
				.build();
	}

	public List<OrdemServicoRetornoDTO> map(List<OrdemServico> ordemsServico) {		
		return ordemsServico.stream()
				.map(ordemServico -> map(ordemServico))
				.toList();
	}	

}

package com.topcarservice.coreapi.domain.usecases.ports;

import java.util.Optional;

import com.topcarservice.coreapi.domain.entities.OrdemServico;

public interface OrdemServicoOutputPort {

	Optional<OrdemServico> findById(Long codigo);

}

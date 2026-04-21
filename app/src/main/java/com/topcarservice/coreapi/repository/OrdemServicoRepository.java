package com.topcarservice.coreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.domain.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}

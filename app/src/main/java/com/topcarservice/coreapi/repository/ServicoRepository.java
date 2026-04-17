package com.topcarservice.coreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.domain.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}

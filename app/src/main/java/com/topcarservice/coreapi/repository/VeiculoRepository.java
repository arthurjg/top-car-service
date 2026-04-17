package com.topcarservice.coreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}

package com.topcarservice.coreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcarservice.coreapi.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

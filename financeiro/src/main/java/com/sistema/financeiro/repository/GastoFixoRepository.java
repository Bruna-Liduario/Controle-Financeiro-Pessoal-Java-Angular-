package com.sistema.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.financeiro.entity.GastoFixo;

public interface GastoFixoRepository extends JpaRepository<GastoFixo, Long> {

}

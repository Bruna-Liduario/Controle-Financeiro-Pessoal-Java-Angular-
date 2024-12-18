package com.sistema.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.financeiro.entity.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{

}

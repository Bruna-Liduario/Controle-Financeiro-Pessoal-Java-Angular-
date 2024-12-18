package com.sistema.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.financeiro.entity.FinanceiroJaneiro;

public interface JaneiroRepository extends JpaRepository<FinanceiroJaneiro, Long>{

	boolean existsByEntradaId(Long id);

}

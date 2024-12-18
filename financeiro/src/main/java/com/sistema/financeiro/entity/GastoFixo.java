package com.sistema.financeiro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="gastofixo")
@Data
public class GastoFixo {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	

    @Column(name="gastofixo", nullable = true)
    private String gastofixo;
    
    @Column(name="valor", nullable = false)
    private Double valor;

}

package com.sistema.financeiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JaneiroDto {
	
	private Long id;
	private Double valorentrada;
	private String gastovariavel;
	private Double valorgastovariavel;
	
	private Long idEntrada;
	private Long idGastoFixo;	

}

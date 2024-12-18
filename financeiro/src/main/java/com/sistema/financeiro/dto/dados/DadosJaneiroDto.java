package com.sistema.financeiro.dto.dados;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosJaneiroDto {
	
	private Long id;
	private Double valorentrada;
	private String gastovariavel;
	private Double valorgastovariavel;
	
	private String descricaoEntrada;
	private String descricaogastofixo;
	private Double valorgastofixo;
	

}

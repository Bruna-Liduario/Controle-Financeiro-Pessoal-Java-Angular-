package com.sistema.financeiro.entity;

import com.sistema.financeiro.dto.JaneiroDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financeirojaneiro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceiroJaneiro {	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(optional = true, fetch = FetchType.EAGER)
		@JoinColumn(name = "entrada_id", referencedColumnName = "id", nullable = true)
	    private Entrada entrada;
	    
	    @Column(name="valorentrada")
	    private Double valorentrada;
	    
	    @ManyToOne(optional = true, fetch = FetchType.EAGER)
		@JoinColumn(name = "gastofixo_id", referencedColumnName = "id", nullable = true)
	    private GastoFixo gastofixo;
  
	    @Column(name="gastovariavel")
	    private String gastovariavel;

	    @Column(name="valorgastovariavel")
	    private Double valorgastovariavel;
	    
	    public JaneiroDto convertEntityToDto() {
	    	JaneiroDto janeiroDto = new JaneiroDto(id, valorentrada, gastovariavel, valorgastovariavel, 
	    			entrada != null ? entrada.getId() : null, 
	    					gastofixo != null ? gastofixo.getId() : null);													 
			
	        return janeiroDto;
		 }
	
}

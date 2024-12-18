package com.sistema.financeiro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.financeiro.dto.JaneiroDto;
import com.sistema.financeiro.dto.dados.DadosJaneiroDto;
import com.sistema.financeiro.entity.Entrada;
import com.sistema.financeiro.entity.FinanceiroJaneiro;
import com.sistema.financeiro.entity.GastoFixo;
import com.sistema.financeiro.exceptions.NotFoundException;
import com.sistema.financeiro.exceptions.ValidacoesException;
import com.sistema.financeiro.repository.EntradaRepository;
import com.sistema.financeiro.repository.GastoFixoRepository;
import com.sistema.financeiro.repository.JaneiroRepository;

@Service
@Transactional
public class FinanceiroJaneiroService {
	
	@Autowired
	private JaneiroRepository janeirorepository;
	
	@Autowired
	private EntradaRepository entradarepository;
	
	@Autowired
	private GastoFixoRepository gastofixorepository;
	
	public List<DadosJaneiroDto> listaFinanceiroJaneiro() {
		List<FinanceiroJaneiro> janeiro = janeirorepository.findAll();
		List<DadosJaneiroDto> listaDadosJaneiro = new ArrayList<DadosJaneiroDto>();
		
		for(FinanceiroJaneiro financeirojaneiro : janeiro) {
			DadosJaneiroDto dadosJaneiro = new DadosJaneiroDto();
			dadosJaneiro.setId(financeirojaneiro.getId());
			dadosJaneiro.setGastovariavel(financeirojaneiro.getGastovariavel());
			dadosJaneiro.setValorgastovariavel(financeirojaneiro.getValorgastovariavel());
			dadosJaneiro.setValorentrada(financeirojaneiro.getValorentrada());
									
			if (financeirojaneiro.getEntrada() != null) {
		        dadosJaneiro.setDescricaoEntrada(financeirojaneiro.getEntrada().getDescricaoentrada());
		    }

		    if (financeirojaneiro.getGastofixo() != null) {
		        dadosJaneiro.setDescricaogastofixo(financeirojaneiro.getGastofixo().getGastofixo());
		        dadosJaneiro.setValorgastofixo(financeirojaneiro.getGastofixo().getValor());
		    }
		       	        	       
	                
			listaDadosJaneiro.add(dadosJaneiro);			
		}	
		
		return listaDadosJaneiro;		
	}	 
	 
	 
	    public FinanceiroJaneiro buscarPorId(Long id) {
	        return janeirorepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Controle Financeiro de Janeiro não encontrado com id " + id));
	    }
	    
	   
		//salvar
		public JaneiroDto salvarFinanceiroJaneiro(JaneiroDto janeiroDto) throws ValidacoesException  {
			verificarExistenciaIdRelacionamentos(janeiroDto);
						
			FinanceiroJaneiro janeiro = convertDtoToEntity(janeiroDto);
			janeiro = janeirorepository.save(janeiro);
			
			return janeiro.convertEntityToDto();
		}
		
		//atualizar
		public JaneiroDto atualizarFinanceiroJaneiro(JaneiroDto janeiroDto) throws ValidacoesException, NotFoundException {
			validarFinanceiroJaneiroExistente(janeiroDto.getId());
			verificarExistenciaIdRelacionamentos(janeiroDto);
						
			FinanceiroJaneiro janeiro = convertDtoToEntity(janeiroDto);
			janeiro = janeirorepository.save(janeiro);
			
			return janeiro.convertEntityToDto();
		}

	   

	    public void excluir(Long id) {
	        if (janeirorepository.existsById(id)) {
	        	janeirorepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Controle Financeiro de Janeiro não encontrado com id " + id);
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		public void validarFinanceiroJaneiroExistente(Long id) throws NotFoundException {
			if (!janeirorepository.existsById(id)) {
	            throw new NotFoundException("Controle Financeiro não cadastrado: " + id);
	        }
		}
		
		public void verificarExistenciaIdRelacionamentos(JaneiroDto janeiroDto) throws ValidacoesException {
			if(janeiroDto.getIdEntrada() != null && !entradarepository.existsById(janeiroDto.getIdEntrada())) {
		        throw new ValidacoesException("Entrada não encontrada!");
		    }
			if(janeiroDto.getIdGastoFixo() != null && !gastofixorepository.existsById(janeiroDto.getIdGastoFixo())) {
		        throw new ValidacoesException("Gasto fixo não encontrado!");
		    }
		}
	    
	    private FinanceiroJaneiro convertDtoToEntity(JaneiroDto janeiroDto) {
	    	FinanceiroJaneiro janeiro = new FinanceiroJaneiro();
	    	janeiro.setId(janeiroDto.getId());
	    	janeiro.setGastovariavel(janeiroDto.getGastovariavel());
	    	janeiro.setValorgastovariavel(janeiroDto.getValorgastovariavel());
			janeiro.setValorentrada(janeiroDto.getValorentrada());
			
			// Relacionamentos	 
		    if (janeiroDto.getIdEntrada() != null) {
		        Entrada entradas = new Entrada();
		        entradas.setId(janeiroDto.getIdEntrada());
		        janeiro.setEntrada(entradas);
		     }
		    
			// Relacionamentos	 
		    if (janeiroDto.getIdGastoFixo() != null) {
		        GastoFixo gastosfixos = new GastoFixo();
		        gastosfixos.setId(janeiroDto.getIdGastoFixo());
		        janeiro.setGastofixo(gastosfixos);
		     }
			return janeiro;

     }
	    
}

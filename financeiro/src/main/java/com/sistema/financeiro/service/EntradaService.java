package com.sistema.financeiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.financeiro.entity.Entrada;
import com.sistema.financeiro.exceptions.ValidacoesException;
import com.sistema.financeiro.repository.EntradaRepository;
import com.sistema.financeiro.repository.JaneiroRepository;

@Service
@Transactional
public class EntradaService {
	
	@Autowired
	private EntradaRepository entradarepository;
	
	@Autowired
	private JaneiroRepository janeiroRepository;
	
	 public List<Entrada> listarTodos() {
	        return entradarepository.findAll();
	    }

	    public Entrada buscarPorId(Long id) {
	        return entradarepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Entrada não encontrada com id " + id));
	    }
	    
	   
	    public Entrada salvar(Entrada entrada) {
	        return entradarepository.save(entrada);
	    }

	   
	    public Entrada editar(Entrada entrada) {
	        Entrada existingEntrada = entradarepository.findById(entrada.getId())
	                .orElseThrow(() -> new RuntimeException("Entrada não encontrada com id " + entrada.getId()));

	        existingEntrada.setDescricaoentrada(entrada.getDescricaoentrada());

	        return entradarepository.save(existingEntrada);
	    }

	   
	    public void excluir(Long id) throws ValidacoesException {
	    	validarPossibilidadeExclusaoEntrada(id);
	        if (entradarepository.existsById(id)) {
	        	entradarepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Entrada não encontrada com id " + id);
	        }
	    }
	    
	    public boolean validarPossibilidadeExclusaoEntrada(Long id) throws ValidacoesException {		
			if(janeiroRepository.existsByEntradaId(id)) {
		        throw new ValidacoesException("Não é possível excluir a entrada pois existem Lançamentos associados a ela");
		    }
		    return true;
		}

}

package com.sistema.financeiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.financeiro.entity.GastoFixo;
import com.sistema.financeiro.repository.GastoFixoRepository;

@Service
@Transactional
public class GastoFixoService {
	
	@Autowired
	private GastoFixoRepository gastofixorepository;
	
	 public List<GastoFixo> listarTodos() {
	        return gastofixorepository.findAll();
	    }

	    public GastoFixo buscarPorId(Long id) {
	        return gastofixorepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Gasto fixo não encontrado com id " + id));
	    }
	    
	   
	    public GastoFixo salvar(GastoFixo gastoFixo) {
	        return gastofixorepository.save(gastoFixo);
	    }

	   
	    public GastoFixo editar(GastoFixo gastoFixo) {
	        GastoFixo existingGastoFixo = gastofixorepository.findById(gastoFixo.getId())
	                .orElseThrow(() -> new RuntimeException("Gasto fixo não encontrado com id " + gastoFixo.getId()));

	        existingGastoFixo.setGastofixo(gastoFixo.getGastofixo());
	        existingGastoFixo.setValor(gastoFixo.getValor());

	        return gastofixorepository.save(existingGastoFixo);
	    }

	   

	    // Excluir um Gasto Fixo
	    public void excluir(Long id) {
	        if (gastofixorepository.existsById(id)) {
	        	gastofixorepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Gasto fixo não encontrado com id " + id);
	        }
	    }

}

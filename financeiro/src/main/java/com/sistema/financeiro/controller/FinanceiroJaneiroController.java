package com.sistema.financeiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sistema.financeiro.dto.JaneiroDto;
import com.sistema.financeiro.dto.dados.DadosJaneiroDto;
import com.sistema.financeiro.entity.FinanceiroJaneiro;
import com.sistema.financeiro.exceptions.NotFoundException;
import com.sistema.financeiro.exceptions.ValidacoesException;
import com.sistema.financeiro.service.FinanceiroJaneiroService;

@RestControllerAdvice
@RestController
@RequestMapping("/janeiro")
public class FinanceiroJaneiroController {
	
	@Autowired
    private FinanceiroJaneiroService janeiroService;

    
    @GetMapping("/lista")
    public ResponseEntity<List<DadosJaneiroDto>> listarTodos() {
        List<DadosJaneiroDto> janeiro = janeiroService.listaFinanceiroJaneiro();
        return new ResponseEntity<>(janeiro, HttpStatus.OK);
    }

    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<FinanceiroJaneiro> buscarPorId(@PathVariable Long id) {
        FinanceiroJaneiro janeiro = janeiroService.buscarPorId(id);
        return new ResponseEntity<>(janeiro, HttpStatus.OK);
    }

   
    @PostMapping("/salvar")
    public ResponseEntity<JaneiroDto> salvar(@RequestBody JaneiroDto janeiroDto) throws ValidacoesException {
    	JaneiroDto novoFinanceiroJaneiro = janeiroService.salvarFinanceiroJaneiro(janeiroDto);
        return new ResponseEntity<>(novoFinanceiroJaneiro, HttpStatus.CREATED);
    }

   
    @PutMapping("/editar")
    public ResponseEntity<JaneiroDto> editar(@RequestBody JaneiroDto janeiroDto) throws ValidacoesException, NotFoundException {
    	JaneiroDto JaneiroEditado = janeiroService.atualizarFinanceiroJaneiro(janeiroDto);
        return new ResponseEntity<>(JaneiroEditado, HttpStatus.OK);
    }

   
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        janeiroService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   

}

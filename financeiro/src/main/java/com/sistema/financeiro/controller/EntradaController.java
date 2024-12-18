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

import com.sistema.financeiro.entity.Entrada;
import com.sistema.financeiro.exceptions.ValidacoesException;
import com.sistema.financeiro.service.EntradaService;

@RestController
@RequestMapping("/entrada")
public class EntradaController {
	
	@Autowired
    private EntradaService entradaService;

    
    @GetMapping("/lista")
    public ResponseEntity<List<Entrada>> listarTodos() {
        List<Entrada> entradas = entradaService.listarTodos();
        return new ResponseEntity<>(entradas, HttpStatus.OK);
    }

    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Entrada> buscarPorId(@PathVariable Long id) {
        Entrada entrada = entradaService.buscarPorId(id);
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

   
    @PostMapping("/salvar")
    public ResponseEntity<Entrada> salvar(@RequestBody Entrada entrada) {
        Entrada novaEntrada = entradaService.salvar(entrada);
        return new ResponseEntity<>(novaEntrada, HttpStatus.CREATED);
    }

   
    @PutMapping("/editar")
    public ResponseEntity<Entrada> editar(@RequestBody Entrada entrada) {
        Entrada entradaEditada = entradaService.editar(entrada);
        return new ResponseEntity<>(entradaEditada, HttpStatus.OK);
    }

   
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) throws ValidacoesException {
        entradaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

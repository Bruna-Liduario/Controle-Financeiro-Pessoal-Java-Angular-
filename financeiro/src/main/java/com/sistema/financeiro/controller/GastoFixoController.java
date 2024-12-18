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

import com.sistema.financeiro.entity.GastoFixo;
import com.sistema.financeiro.service.GastoFixoService;

@RestController
@RequestMapping("/gastofixo")
public class GastoFixoController {
	
	@Autowired
    private GastoFixoService gastoFixoService;

    
    @GetMapping("/lista")
    public ResponseEntity<List<GastoFixo>> listarTodos() {
        List<GastoFixo> gastosFixos = gastoFixoService.listarTodos();
        return new ResponseEntity<>(gastosFixos, HttpStatus.OK);
    }

    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<GastoFixo> buscarPorId(@PathVariable Long id) {
        GastoFixo gastoFixo = gastoFixoService.buscarPorId(id);
        return new ResponseEntity<>(gastoFixo, HttpStatus.OK);
    }

   
    @PostMapping("/salvar")
    public ResponseEntity<GastoFixo> salvar(@RequestBody GastoFixo gastoFixo) {
        GastoFixo novoGastoFixo = gastoFixoService.salvar(gastoFixo);
        return new ResponseEntity<>(novoGastoFixo, HttpStatus.CREATED);
    }

   
    @PutMapping("/editar")
    public ResponseEntity<GastoFixo> editar(@RequestBody GastoFixo gastoFixo) {
        GastoFixo gastoFixoEditado = gastoFixoService.editar(gastoFixo);
        return new ResponseEntity<>(gastoFixoEditado, HttpStatus.OK);
    }

   
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        gastoFixoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

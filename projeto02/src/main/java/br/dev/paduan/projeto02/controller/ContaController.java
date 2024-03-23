package br.dev.paduan.projeto02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.paduan.projeto02.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    
    @Autowired
    ContaService service;

    @GetMapping("/{numero}")
    public ResponseEntity<Double> getSaldo(@PathVariable int numero) {
        double saldo = service.getSaldo(numero);
        if(saldo >= 0){
            return ResponseEntity.ok(saldo);
        }
        return ResponseEntity.notFound().build();
    }
    
}

package br.paduan.projeto01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controller
public class HelloController {
    
    @GetMapping // Esse metodo será acionado por uma chamada http GET
    public String helloWorld() {
        return "Boa noite!";
    }

}

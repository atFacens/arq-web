package br.paduan.projeto01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.paduan.projeto01.model.Product;
import br.paduan.projeto01.service.ProductService;

@RestController
@RequestMapping("/produto")
public class ProducController {
    
    @Autowired
    private ProductService service;

    @GetMapping("/{codigo}")
    public ResponseEntity<Product> getById(@PathVariable int codigo) {
        Product product = service.getById(codigo);
        if(product != null){
            return ResponseEntity.ok(product);
        }
         return ResponseEntity.notFound().build();       
    }

    // @PostMapping
    // public ResponseEntity<Product> insert(@RequestBody Product product) {

    //      Product newProduct = service.insert(product);
         
    //     return ResponseEntity.ok(newProduct);

    // }

}
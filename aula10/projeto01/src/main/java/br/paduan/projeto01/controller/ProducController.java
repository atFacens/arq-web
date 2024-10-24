package br.paduan.projeto01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        Optional<Product> optionalProduct = service.getById(codigo);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.findAll();

        if(products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }


    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        Optional<Product> optionalProduct = service.insert(product);

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = service.deleteById(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable int id) {
        Optional<Product> optionalProduct = service.update(product, id);

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updatePartial(@RequestBody Product product, @PathVariable int id) {
        Optional<Product> optionalProduct = service.updatePartial(product, id);

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
    }

}
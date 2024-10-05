package br.paduan.projeto01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paduan.projeto01.model.Product;
import br.paduan.projeto01.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public Optional<Product> getById(int id) {
        return repository.findById(id);
    }

    public Optional<Product> insert(Product product) {
        if(product.getId() != 0) {
            return Optional.empty();
        }
        return Optional.of(repository.save(product));
    }
}

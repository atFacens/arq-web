package br.paduan.projeto01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paduan.projeto01.model.Product;
import br.paduan.projeto01.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public Product getById(int id) {
        return repository.getById(id);
    }

    public Product insert(Product product) {
        return repository.insert(product);
    }
}

package br.paduan.projeto01.service;

import java.util.List;
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

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    public boolean deleteById(int id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if(optionalProduct.isEmpty()) {
            return false;
        }
        repository.deleteById(id);
        
        return true;
    }
}

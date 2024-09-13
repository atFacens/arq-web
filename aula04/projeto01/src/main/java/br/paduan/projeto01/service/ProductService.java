package br.paduan.projeto01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.paduan.projeto01.model.Product;

@Service
public class ProductService {
    private List<Product> products = List.of(
        new Product(1, "Mouse", 50.0),
        new Product(2, "Teclado", 100.0),
        new Product(3, "Monitor", 500.0)
    );

    
    public Product getById(int id) {
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}

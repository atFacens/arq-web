package br.paduan.projeto01.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.paduan.projeto01.model.Product;

@Repository
public class ProductRepository {
    private List<Product> dados = List.of(
        new Product(1, "Mouse", 50.0),
        new Product(2, "Teclado", 100.0),
        new Product(3, "Monitor", 500.0)
    );
    List<Product> products = new ArrayList<>();
    
    public ProductRepository() {
        dados.forEach((e)->{
            products.add(e);
        });
    }

    public Product getById(int id) {
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public Product insert(Product product) {
        int cod = products.size() + 1;
        product.setId(cod);

        products.add(product);

        return product;
    }
}

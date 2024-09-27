package br.paduan.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.paduan.projeto01.model.Product;

// Crud = Create, Read, Update, Delete
public interface ProductRepository extends CrudRepository<Product, Integer> {
   
}

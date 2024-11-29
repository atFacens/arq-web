package br.paduan.projeto01.model.dto;

import br.paduan.projeto01.model.Product;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank
    private String name;
    private double value;

    public ProductDTO() {
    }

    public ProductDTO(String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    public Product toProduct() {
        return new Product(0, name, value);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    
}

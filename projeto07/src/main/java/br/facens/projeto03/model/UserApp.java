package br.facens.projeto03.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserApp {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    private long id;
    
    private String name;
    
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Produto> produtos;
    
    public UserApp() {
    }

    public UserApp(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
package br.facens.projeto03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserApp {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    private long id;
    
    private String name;
    private String email;
    
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
    

    
}
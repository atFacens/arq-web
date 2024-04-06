package br.facens.projeto03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.projeto03.model.UserApp;
import br.facens.projeto03.service.UserAppService;

@RestController
@RequestMapping("/user")
public class UserAppController {
    
    @Autowired
    UserAppService service;

    @PostMapping
    public ResponseEntity<UserApp> createUser(@RequestBody UserApp user) {
        UserApp newUser = service.createUser(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserApp> getUserApp(@PathVariable long id) {
        Optional<UserApp> userOptinal = service.getUserApp(id);

        if(userOptinal.isPresent()) {
            return ResponseEntity.ok(userOptinal.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UserApp>> getAllUserApp() {
        List<UserApp> listUser = service.getAllUserApp();

        if(listUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean result = service.delete(id);

        if(result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

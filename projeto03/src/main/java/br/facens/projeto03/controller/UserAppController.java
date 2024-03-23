package br.facens.projeto03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        
        return ResponseEntity.ok(newUser);
    }

}

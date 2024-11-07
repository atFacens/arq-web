package br.paduan.projeto01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.paduan.projeto01.model.UserApp;
import br.paduan.projeto01.service.UserAppService;

@RestController
@RequestMapping("/user")
public class UserAppController {

    @Autowired
    private UserAppService service;

    @GetMapping("/{codigo}")
    public ResponseEntity<UserApp> getById(@PathVariable int codigo) {
        Optional<UserApp> optionalUser = service.getById(codigo);

        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserApp> getById(@PathVariable String email) {
        Optional<UserApp> optionalUser = service.getByEmail(email);

        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/email2/{email}")
    public ResponseEntity<UserApp> getByEmail(@PathVariable String email) {
        UserApp user = service.buscarPorEmail(email);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/email3/{email}")
    public ResponseEntity<UserApp> getByEmailSQL(@PathVariable String email) {
        UserApp user = service.buscarPorEmailSQL(email);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}

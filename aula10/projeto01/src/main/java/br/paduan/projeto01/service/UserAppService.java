package br.paduan.projeto01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paduan.projeto01.model.UserApp;
import br.paduan.projeto01.repository.UserAppRepo;

@Service
public class UserAppService {

    @Autowired
    private UserAppRepo repo;

    public Optional<UserApp> getById(int id) {
        return repo.findById(id);
    }

    public Optional<UserApp> getByEmail(String email) {
        return repo.findByEmail(email);
    }
}

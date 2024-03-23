package br.facens.projeto03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.projeto03.model.UserApp;
import br.facens.projeto03.repository.UserAppRepo;

@Service
public class UserAppService {
    
    @Autowired
    UserAppRepo repo;

    public UserApp createUser(UserApp user) {
        return repo.save(user);
    }

}

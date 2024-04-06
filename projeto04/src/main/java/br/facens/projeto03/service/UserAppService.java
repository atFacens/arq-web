package br.facens.projeto03.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<UserApp> getUserApp(long id) {
        Optional<UserApp> user = repo.findById(id);

        return user;
    }

    public List<UserApp> getAllUserApp() {
        List<UserApp> listUser = repo.findAll();

        return listUser;
    }

    public boolean delete(long id) {
        Optional<UserApp> user = repo.findById(id);

        if (user.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        
        return false;
    }

}

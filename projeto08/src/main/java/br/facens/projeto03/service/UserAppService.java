package br.facens.projeto03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.projeto03.model.UserApp;
import br.facens.projeto03.model.UserAppDTO;
import br.facens.projeto03.repository.UserAppRepo;

@Service
public class UserAppService {

    @Autowired
    UserAppRepo repo;

    public UserApp createUser(UserApp user) {
        if(user.getId() > 0) {
            return null;
        }
        return repo.save(user);
    }

    public Optional<UserApp> getUserApp(long id) {
        Optional<UserApp> user = repo.findById(id);

        return user;
    }

    public Optional<UserAppDTO> getUserAppDTO(long id) {
        Optional<UserApp> userOptional = repo.findById(id);

        if(userOptional.isEmpty()){
            return Optional.ofNullable(null);
        }
        UserAppDTO userAppDTO = new UserAppDTO(userOptional.get());
        return Optional.of(userAppDTO);
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

    public UserApp updateAllDataUser(UserApp user) {
        Optional<UserApp> optionalUser = repo.findById(user.getId());

        if(optionalUser.isEmpty()) {
            return null;
        }
        return repo.save(user);
    }

    public UserApp updateSomeDataUser(UserApp user) {
        Optional<UserApp> optionalUser = repo.findById(user.getId());

        if(optionalUser.isEmpty()) {
            return null;
        }
        UserApp currentUser = optionalUser.get();

        if(user.getName() != null) {
            currentUser.setName(user.getName());
        }

        if(user.getEmail() != null) {
            currentUser.setEmail(user.getEmail());
        }

        return repo.save(currentUser);
    }

    public UserApp getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public UserApp buscarPorEmail(String email) {
        return repo.buscarPorEmail(email);
    }

    public UserApp buscarNativoPorEmail(String email) {
        return repo.buscarPorEmail(email);
    }
}

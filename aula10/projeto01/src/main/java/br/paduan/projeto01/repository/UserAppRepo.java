package br.paduan.projeto01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.paduan.projeto01.model.UserApp;

public interface UserAppRepo extends CrudRepository<UserApp, Integer> {
    Optional<UserApp> findByEmail(String email);
}

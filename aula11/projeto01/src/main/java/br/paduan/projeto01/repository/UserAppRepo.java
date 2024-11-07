package br.paduan.projeto01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.paduan.projeto01.model.UserApp;

public interface UserAppRepo extends CrudRepository<UserApp, Integer> {
    Optional<UserApp> findByEmail(String email);

    @Query("select u from UserApp u where u.email = ?1")
    UserApp buscarPorEmail(String email);

    @Query(value = "select * from user_app where email = ?1", nativeQuery = true)
    UserApp buscarPorEmailSQL(String email);
}

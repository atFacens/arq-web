package br.facens.projeto03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facens.projeto03.model.UserApp;


@Repository
public interface UserAppRepo extends JpaRepository<UserApp, Long>{
    UserApp findByEmail(String email);
}

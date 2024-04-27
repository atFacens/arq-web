package br.facens.projeto03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.facens.projeto03.model.UserApp;


@Repository
public interface UserAppRepo extends JpaRepository<UserApp, Long>{
    UserApp findByEmail(String email);

    // JPQL
    @Query("select u from UserApp u where u.email = ?1")
    UserApp buscarPorEmail(String email);

    // Nativa do BD
    @Query(value = "select * from user_app where email = ?1", nativeQuery = true)
    UserApp buscarNativaPorEmail(String email);

}

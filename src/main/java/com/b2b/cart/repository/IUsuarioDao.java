package com.b2b.cart.repository;

import com.b2b.cart.models.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario findByUsername2(String username);

}

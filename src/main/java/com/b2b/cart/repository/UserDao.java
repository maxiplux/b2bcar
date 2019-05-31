package com.b2b.cart.repository;

import com.b2b.cart.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //@Query("select u from USER u where u.username=?1")
    //User findByUsername2(String username);

}

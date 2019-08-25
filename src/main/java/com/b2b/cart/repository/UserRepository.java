package com.b2b.cart.repository;

import com.b2b.cart.models.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    //@Query("select u from USER u where u.username=?1")
    //User findByUsername2(String username);

}
